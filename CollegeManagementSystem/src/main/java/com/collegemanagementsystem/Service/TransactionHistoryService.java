package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.FeeDivisionDto;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Entity.FeeDivision;
import com.collegemanagementsystem.Entity.TransactionHistory;
import com.collegemanagementsystem.Repository.FeeDivisionRepository;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TransactionHistoryRepository;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {

    @Autowired
    ModelMapper mapper;
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private FeeDivisionRepository feeDivisionRepository;

    @Autowired
    private StudentRepository studentrepo;
    @Autowired
    private SendEmailService emailService;
    @Autowired
    private PaymentCSV csv;
    @Autowired
    private PaymentCsvtoPdf paymentpdf;

    public void addTransaction(TransactionHistoryDto dto){
        TransactionHistory transactionHistory=mapper.map(dto, TransactionHistory.class);
        Long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        transactionHistory.setDate(date);
        java.sql.Time time = new java.sql.Time(millis);
        transactionHistory.setTime(time);
        transactionHistoryRepository.save(transactionHistory);
        for (FeeDivisionDto fee: dto.getFeeDivision()){
            FeeDivision feeDivision= new FeeDivision();
            feeDivision.setTransactionId(dto.getTransactionId());
            feeDivision.setFeeDivisionName(fee.getFeeDivisionName());
            feeDivision.setAmount(fee.getAmount());
            feeDivisionRepository.save(feeDivision);
        }

        return ;
    }
    public List<TransactionHistoryDto> FindById(Long UserId) {
        List<TransactionHistoryDto> transactions = new ArrayList<>();
        List<TransactionHistory> trans =   transactionHistoryRepository.getById(UserId);
        if(trans!=null){
        for(TransactionHistory newTran:trans){
           List<FeeDivision> fee=feeDivisionRepository.getByTransactionId(newTran.getTransactionId());
           TransactionHistoryDto transactionDto=mapper.map(newTran,TransactionHistoryDto.class);
           transactionDto.setFeeDivision(fee.stream().map(x-> mapper.map(x, FeeDivisionDto.class)).collect(Collectors.toList()));
           transactions.add(transactionDto);
       }}
        return transactions;
    }
    public List<TransactionHistoryDto> FindByTransactionId(String transactionId) {
        TransactionHistory trans =   transactionHistoryRepository.getByTransactionId(transactionId);
        List<TransactionHistoryDto> transactions = new ArrayList<>();

        if(trans!=null){
            TransactionHistoryDto transactionDto= mapper.map(trans, TransactionHistoryDto.class);
        List<FeeDivision> fee=feeDivisionRepository.getByTransactionId(trans.getTransactionId());
        transactionDto.setFeeDivision(fee.stream().map(x-> mapper.map(x, FeeDivisionDto.class)).collect(Collectors.toList()));
        transactions.add(transactionDto);
        }
        return transactions;
    }
    public List<TransactionHistoryDto> FindByDate(Date startD, Date endD) throws MessagingException, UnsupportedEncodingException {
        List<TransactionHistoryDto> transactions = new ArrayList<>();
        List<TransactionHistory> trans =   transactionHistoryRepository.getByDate(startD,endD);
        if(trans!=null){
        for(TransactionHistory newTran:trans){
            List<FeeDivision> fee=feeDivisionRepository.getByTransactionId(newTran.getTransactionId());
            TransactionHistoryDto transactionDto=mapper.map(newTran,TransactionHistoryDto.class);
            transactionDto.setFeeDivision(fee.stream().map(x-> mapper.map(x, FeeDivisionDto.class)).collect(Collectors.toList()));
            transactions.add(transactionDto);
        }}
        return transactions;
    }

    public List<TransactionHistoryDto> FindByEmail(String email) {
        List<TransactionHistoryDto> transactions = new ArrayList<>();
        List<TransactionHistory> trans =   transactionHistoryRepository.getByEmail(email);
        if(trans!=null){
            for(TransactionHistory newTran:trans){
                List<FeeDivision> fee=feeDivisionRepository.getByTransactionId(newTran.getTransactionId());
                TransactionHistoryDto transactionDto=mapper.map(newTran,TransactionHistoryDto.class);
                transactionDto.setFeeDivision(fee.stream().map(x-> mapper.map(x, FeeDivisionDto.class)).collect(Collectors.toList()));
                transactions.add(transactionDto);
            }}
        return transactions;
    }

    public void sendCsv(String email, Date startD, Date endD) throws MessagingException, UnsupportedEncodingException {
        List<TransactionHistory> trans =   transactionHistoryRepository.getByDate(startD,endD);
        Map subDetails = new HashMap();
        subDetails.put("Start Date:",startD.toString());
        subDetails.put("End Date:",endD.toString());
        String[] details = new String[100];
        List<String[]> completeDetails = new ArrayList<>();
        int i = 0;
        details[i++] = "Registration No";
        details[i++] = "Student Name";
        details[i++] = "Total Amount";
        details[i++] = "Payment Type";
        details[i++] = "Payment Id";
        details[i++] = "Fee Divisions";
        details[i++] = "Date";
        details[i++] = "Time";
        completeDetails.add(details);
        for(TransactionHistory newTran:trans){
            List<FeeDivision> fee=feeDivisionRepository.getByTransactionId(newTran.getTransactionId());
            details = new String[1000];
            i = 0;
            details[i++] = newTran.getRegistrationNo();
            details[i++] = newTran.getName();
            details[i++] = String.valueOf(newTran.getTotalAmount());
            details[i++] = newTran.getPaymentType();
            details[i++] = newTran.getTransactionId();

            List<String> feeDivision = new ArrayList<>();
            for(FeeDivision newFee: fee){
                var j=0;
                feeDivision.add(newFee.getFeeDivisionName()+":" + newFee.getAmount());

            }
            details[i++] = feeDivision.toString();
            details[i++] = newTran.getDate().toString();
            // details[i++] = newTran.getTime().toString();
            completeDetails.add(details);

        }
        csv.createCsv(subDetails, completeDetails);
        paymentpdf.generatePdf(subDetails,completeDetails);
        System.out.println(completeDetails.get(0)[1]);
        emailService.sendEmail(email, "transaction report", "Please find the attachment", "transaction.csv",  "C:\\Users\\RAM BABU SINGH\\Desktop\\sample.pdf");

       // emailService.sendEmail(email, "transaction report", "Please find the attachment", "transaction.csv", "C:\\Users\\RAM BABU SINGH\\Desktop\\transaction.csv");

    }
}

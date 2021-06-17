package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.FeeDivisionDto;
import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Dto.TokenRegistrationDTO;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Entity.FeeDivision;
import com.collegemanagementsystem.Entity.StudentTopicEntity;
import com.collegemanagementsystem.Entity.TransactionHistory;
import com.collegemanagementsystem.Repository.FeeDivisionRepository;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TransactionHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
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

    public Map addTransaction(TransactionHistoryDto dto){
        TransactionHistory transactionHistory=mapper.map(dto, TransactionHistory.class);
        transactionHistoryRepository.save(transactionHistory);
        for (FeeDivisionDto fee: dto.getFeeDivision()){
            FeeDivision feeDivision= new FeeDivision();
            feeDivision.setTransactionId(dto.getTransactionId());
            feeDivision.setFeeDivisionName(fee.getFeeDivisionName());
            feeDivision.setAmount(fee.getAmount());
            feeDivisionRepository.save(feeDivision);
        }
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Added successfully");
        return msg;
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
    public List<TransactionHistoryDto> FindByDate(Date startD, Date endD) {

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

}

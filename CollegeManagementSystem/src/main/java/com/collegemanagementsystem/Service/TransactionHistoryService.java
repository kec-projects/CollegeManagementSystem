package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.FeeDivisionDto;
import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Dto.TokenRegistrationDTO;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Entity.FeeDivision;
import com.collegemanagementsystem.Entity.TransactionHistory;
import com.collegemanagementsystem.Repository.FeeDivisionRepository;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TransactionHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    public String addTransaction(TransactionHistoryDto dto){
        TransactionHistory transactionHistory=mapper.map(dto, TransactionHistory.class);
        transactionHistoryRepository.save(transactionHistory);
        for (FeeDivisionDto fee: dto.getFeeDivision()){
            FeeDivision feeDivision= new FeeDivision();
        feeDivision.setTransactionId(dto.getTransactionId());
        feeDivision.setFeeDivisionName(fee.getFeeDivisionName());
        feeDivision.setAmount(fee.getAmount());
            feeDivisionRepository.save(feeDivision);
        }

        return " Transaction Data Added Successfilly";
    }
    public List<TransactionHistoryDto> FindById(Long UserId) {
       List<TransactionHistory> trans =   transactionHistoryRepository.getById(UserId);
        return trans.stream().map(x-> mapper.map(x, TransactionHistoryDto.class)).collect(Collectors.toList());
    }
    public TransactionHistoryDto FindByTransactionId(String transactionId) {
        TransactionHistory trans =   transactionHistoryRepository.getByTransactionId(transactionId);
        return mapper.map(trans, TransactionHistoryDto.class);
    }
    public List<TransactionHistoryDto> FindByDate(Date startD, Date endD) {
        List<TransactionHistory> trans =   transactionHistoryRepository.getByDate(startD,endD);
        return trans.stream().map(x-> mapper.map(x, TransactionHistoryDto.class)).collect(Collectors.toList());
    }

}

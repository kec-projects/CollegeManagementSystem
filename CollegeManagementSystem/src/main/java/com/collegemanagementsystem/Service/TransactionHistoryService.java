package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.FeeDivisionDto;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Entity.FeeDivision;
import com.collegemanagementsystem.Entity.TransactionHistory;
import com.collegemanagementsystem.Entity.profileEntity.Student;
import com.collegemanagementsystem.Repository.FeeDivisionRepository;
import com.collegemanagementsystem.Repository.StudentRepository;
import com.collegemanagementsystem.Repository.TransactionHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Student student=studentrepo.RegistrationNo(dto.getRegistrationNo());
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

}

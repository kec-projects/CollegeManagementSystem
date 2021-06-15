package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionHistoryController {
    @Autowired
    private TransactionHistoryService transactionHistoryService;
    @PostMapping("/addTransactions")
    public String addTransactions(@RequestBody TransactionHistoryDto transactionHistoryDto){
        return transactionHistoryService.addTransaction(transactionHistoryDto);
    }

}

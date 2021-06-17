package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.DateDto;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionHistoryController {
    @Autowired
    private TransactionHistoryService transactionHistoryService;
    @PostMapping("/addTransactions")
    public Map addTransactions(@RequestBody TransactionHistoryDto transactionHistoryDto){
        return transactionHistoryService.addTransaction(transactionHistoryDto);
    }

    @GetMapping("/find/Id")
    public List<TransactionHistoryDto> FindById(@RequestParam Long userId){
        return transactionHistoryService.FindById(userId);
    }
    @GetMapping("/find/TransactionId")
    public List<TransactionHistoryDto> FindByTransactionId(@RequestParam String transactionId){
        return transactionHistoryService.FindByTransactionId(transactionId);
    }


    @PostMapping("/find/Date")
    public List<TransactionHistoryDto> FindByDate(@RequestBody DateDto dto){
        return transactionHistoryService.FindByDate(dto.getStartD(),dto.getEndD());
    }

}

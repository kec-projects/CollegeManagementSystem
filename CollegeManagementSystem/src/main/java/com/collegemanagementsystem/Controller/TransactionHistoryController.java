package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.DateDto;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
import com.collegemanagementsystem.Service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionHistoryController {
    @Autowired
    private TransactionHistoryService transactionHistoryService;
    @PostMapping("/addTransactions")
    public Map addTransactions(@RequestBody TransactionHistoryDto transactionHistoryDto){
        transactionHistoryService.addTransaction(transactionHistoryDto);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Added successfully");
        return msg;
    }

    @GetMapping("/find/Id")
    public List<TransactionHistoryDto> FindById(@RequestParam Long userId){
        return transactionHistoryService.FindById(userId);
    }
    @GetMapping("/find/TransactionId")
    public List<TransactionHistoryDto> FindByTransactionId(@RequestParam String transactionId){
        return transactionHistoryService.FindByTransactionId(transactionId);
    }

    @GetMapping("/find/email")
    public List<TransactionHistoryDto> FindByEmail(@RequestParam String email){
        return transactionHistoryService.FindByEmail(email);
    }

    @PostMapping("/find/Date")
    public List<TransactionHistoryDto> FindByDate(@RequestBody DateDto dto) throws MessagingException, UnsupportedEncodingException {
        return transactionHistoryService.FindByDate(dto.getStartD(),dto.getEndD());
    }

    @PostMapping("/send")
    public Map sendCsv(@RequestBody DateDto dto) throws MessagingException, UnsupportedEncodingException {
        transactionHistoryService.sendCsv(dto.getEmail(), dto.getStartD(),dto.getEndD());
        Map msg=new HashMap();
        msg.put("Message","Report Generated and Emailed");
        msg.put("Status","Successful");
        return msg;
    }

}

package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.PaymentListDto;
import com.collegemanagementsystem.Service.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class PaymentDetailController {
    @Autowired
    private PaymentDetailService paymentDetailService;

    @PostMapping(value = "/addpayment")
    public Map addpayment(@RequestBody PaymentListDto dto){
         paymentDetailService.addpayment(dto);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Added successfully");
        return msg;
    }

    @GetMapping("/get/paymentTypes")
    public Set<Map> getPaymentTypes(){
        return paymentDetailService.getPayments();
    }

    @GetMapping("/get/paymentName")
    public Set<Map> getPaymentName(@RequestParam String paymentType){
        return paymentDetailService.getPaymentName(paymentType);
    }
    @GetMapping("/get/paymentAmount")
    public Set<Map> getPaymentAmountByCategory(@RequestParam String paymentType, @RequestParam String category){
        return paymentDetailService.getPaymentAmountByCategoryandPaymentType(paymentType,category);
    }

    @DeleteMapping("/delete/paymentType")
    public Map deleteBypaymentType(@RequestParam String paymentType){
        paymentDetailService.DeleteByPaymentType(paymentType);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Deleted successfully");
        return msg;
    }
    @DeleteMapping("/delete/paymentName")
    public Map deleteBypaymentTypeAndName(@RequestParam String paymentType,@RequestParam String paymentName){
       paymentDetailService.DeleteByPaymentTypeAndPaymentName(paymentType,paymentName);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data deleted successfully");
        return msg;
    }
    @PutMapping("/update/paymentType")
    public Map upgatePaymentType(@RequestParam String newPaymentType,@RequestParam String oldPaymentType){
        paymentDetailService.updatePaymentType(newPaymentType,oldPaymentType);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Updated successfully");
        return msg;
    }
    @PutMapping("/update/paymentName")
    public Map updatePaymentName(@RequestParam String paymentType,@RequestParam String paymentName){
        paymentDetailService.updatePaymentName(paymentType,paymentName);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data updated successfully");
        return msg;
    }
    @PutMapping("/update/amount")
    public Map updatePaymentAmount(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam Double amount){
        paymentDetailService.updateAmount(paymentType,paymentName,amount);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data updated successfully");
        return msg;
    }

    @PutMapping("/update/category")
    public Map updateCategory(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam String category){
      paymentDetailService.updateCategory(paymentType,paymentName,category);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data updated successfully");
        return msg;
    }


}

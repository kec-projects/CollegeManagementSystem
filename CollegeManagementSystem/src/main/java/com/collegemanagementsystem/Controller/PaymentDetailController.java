package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.PaymentDetailDto;
import com.collegemanagementsystem.Service.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentDetailController {
    @Autowired
    private PaymentDetailService paymentDetailService;

    @PostMapping(value = "/addpayment")
    public String addpayment(@RequestBody PaymentDetailDto dto){
        paymentDetailService.addpayment(dto);
        return "Data Added";
    }

    @GetMapping("/get/paymentTypes")
    public List getPaymentTypes(){
        return paymentDetailService.getPayments();
    }

    @GetMapping("/get/paymentName")
    public List getPaymentName(@RequestParam String paymentType){
        return paymentDetailService.getPaymentName(paymentType);
    }
    @GetMapping("/get/paymentAmount")
    public List getPaymentAmountByCategory(@RequestParam String category){
        return paymentDetailService.getPaymentAmountByCategory(category);
    }

    @DeleteMapping("/delete/paymentType")
    public String deleteBypaymentType(@RequestParam String paymentType){
        return paymentDetailService.DeleteByPaymentType(paymentType);
    }
    @DeleteMapping("/delete/paymentName")
    public String deleteBypaymentTypeAndName(@RequestParam String paymentType,@RequestParam String paymentName){
        return paymentDetailService.DeleteByPaymentTypeAndPaymentName(paymentType,paymentName);
    }
    @PutMapping("/update/paymentType")
    public String upgatePaymentType(@RequestParam String newPaymentType,@RequestParam String oldPaymentType){
        return paymentDetailService.updatePaymentType(newPaymentType,oldPaymentType);
    }
    @PutMapping("/update/paymentName")
    public String updatePaymentName(@RequestParam String paymentType,@RequestParam String paymentName){
        return paymentDetailService.updatePaymentName(paymentType,paymentName);
    }
    @PutMapping("/update/amount")
    public String updatePaymentAmount(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam Double amount){
        return paymentDetailService.updateAmount(paymentType,paymentName,amount);
    }

    @PutMapping("/update/category")
    public String updateCategory(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam String category){
        return paymentDetailService.updateCategory(paymentType,paymentName,category);
    }


}

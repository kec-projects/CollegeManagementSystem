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

    @PostMapping("/get/paymentName")
    public List getPaymentName(@RequestParam String paymentType){
        return paymentDetailService.getPaymentName(paymentType);
    }
    @PostMapping("/get/paymentAmount")
    public List getPaymentAmountByCategory(@RequestParam String category){
        return paymentDetailService.getPaymentAmountByCategory(category);
    }

    @PostMapping("/delete/paymentType")
    public String deleteBypaymentType(@RequestParam String paymentType){
        return paymentDetailService.DeleteByPaymentType(paymentType);
    }
    @PostMapping("/delete/paymentName")
    public String deleteBypaymentTypeAndName(@RequestParam String paymentType,@RequestParam String paymentName){
        return paymentDetailService.DeleteByPaymentTypeAndPaymentName(paymentType,paymentName);
    }
    @PostMapping("/update/paymentType")
    public String upgatePaymentType(@RequestParam String newPaymentType,@RequestParam String oldPaymentType){
        return paymentDetailService.updatePaymentType(newPaymentType,oldPaymentType);
    }
    @PostMapping("/update/paymentName")
    public String updatePaymentName(@RequestParam String paymentType,@RequestParam String paymentName){
        return paymentDetailService.updatePaymentName(paymentType,paymentName);
    }
    @PostMapping("/update/amount")
    @ResponseBody
    public String updatePaymentAmount(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam Long amount){
        return paymentDetailService.updateAmount(paymentType,paymentName,amount);
    }

    @PostMapping("/update/category")
    public String updateCategory(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam String category){
        return paymentDetailService.updateCategory(paymentType,paymentName,category);
    }


}

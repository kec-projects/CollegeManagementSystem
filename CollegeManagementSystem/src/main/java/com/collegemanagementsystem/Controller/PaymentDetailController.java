package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.PaymentDetailDto;
import com.collegemanagementsystem.Service.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class PaymentDetailController {
    @Autowired
    private PaymentDetailService paymentDetailService;

    @PostMapping(value = "/addpayment")
    public Map addpayment(@RequestBody List<PaymentDetailDto> dto){
        return paymentDetailService.addpayment(dto);
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
        return paymentDetailService.DeleteByPaymentType(paymentType);
    }
    @DeleteMapping("/delete/paymentName")
    public Map deleteBypaymentTypeAndName(@RequestParam String paymentType,@RequestParam String paymentName){
        return paymentDetailService.DeleteByPaymentTypeAndPaymentName(paymentType,paymentName);
    }
    @PutMapping("/update/paymentType")
    public Map upgatePaymentType(@RequestParam String newPaymentType,@RequestParam String oldPaymentType){
        return paymentDetailService.updatePaymentType(newPaymentType,oldPaymentType);
    }
    @PutMapping("/update/paymentName")
    public Map updatePaymentName(@RequestParam String paymentType,@RequestParam String paymentName){
        return paymentDetailService.updatePaymentName(paymentType,paymentName);
    }
    @PutMapping("/update/amount")
    public Map updatePaymentAmount(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam Double amount){
        return paymentDetailService.updateAmount(paymentType,paymentName,amount);
    }

    @PutMapping("/update/category")
    public Map updateCategory(@RequestParam String paymentType,@RequestParam String paymentName,@RequestParam String category){
        return paymentDetailService.updateCategory(paymentType,paymentName,category);
    }


}

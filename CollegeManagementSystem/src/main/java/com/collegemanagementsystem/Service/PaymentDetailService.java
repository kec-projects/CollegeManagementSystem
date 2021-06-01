package com.collegemanagementsystem.Service;
import com.collegemanagementsystem.Dto.PaymentDetailDto;
import com.collegemanagementsystem.Entity.PaymentDetail;
import com.collegemanagementsystem.Entity.TopicEntity;
import com.collegemanagementsystem.Repository.PaymentDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentDetailService {
    @Autowired
    private PaymentDetailRepository paymentrepo;
    @Autowired
    ModelMapper mapper;

    public PaymentDetailDto addpayment(PaymentDetailDto paymentDetailDtodto){
        PaymentDetail payments=mapper.map(paymentDetailDtodto, PaymentDetail.class);
        paymentrepo.save(payments);
        return mapper.map(payments, PaymentDetailDto.class);
    }

    public String DeleteByPaymentType(String paymentType){
         paymentrepo.deleteByPaymentType(paymentType);
         return "deleted";
    }

    public String updatePaymentType(String newPaymentType,String oldPaymentType){
        paymentrepo.updatePaymentType(newPaymentType,oldPaymentType);
        return "updated";
    }

    public String DeleteByPaymentTypeAndPaymentName(String paymentType,String paymentName){
         paymentrepo.deleteByPaymentNameAndPaymentType(paymentName,paymentType);
        return "deleted";
    }
    public String updatePaymentName(String paymentType,String paymentName){
        paymentrepo.updatePaymentName(paymentType,paymentName);
        return "updated";
    }

    public String updateAmount(String paymentType,String paymentName,Double amount){
        paymentrepo.updateAmount(paymentType,paymentName,amount);
        return "updated";
    }
    public String updateCategory(String paymentType,String paymentName,String category){
        paymentrepo.updateCategory(paymentType,paymentName,category);
        return "updated";
    }



    public List getPayments(){
       List<PaymentDetail>payments=paymentrepo.findAll();
        List<String> paymentTypes=new ArrayList<>();
        for (PaymentDetail payment: payments){
            paymentTypes.add(payment.getPaymentType());
        }
        return paymentTypes.stream().distinct().collect(Collectors.toList());
    }
    public List getPaymentName(String paymentType){
        List<PaymentDetail> payments=paymentrepo.getPaymentDetailByPaymentType(paymentType);
        List<String> paymentTypes=new ArrayList<>();
        for (PaymentDetail payment: payments){
            paymentTypes.add(payment.getPaymentName());
        }
        return paymentTypes.stream().distinct().collect(Collectors.toList());
    }
    public List getPaymentAmountByCategory(String category){
        List<PaymentDetail> payments=paymentrepo.getPaymentDetailByCategory(category);
        List<Double> amount=new ArrayList<>();
        for (PaymentDetail payment: payments){
            amount.add(payment.getAmount());
        }
        return amount;
    }

}

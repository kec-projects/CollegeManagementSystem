package com.collegemanagementsystem.Service;
import com.collegemanagementsystem.Dto.PaymentDetailDto;
import com.collegemanagementsystem.Entity.PaymentDetail;
import com.collegemanagementsystem.Repository.PaymentDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Set<Map> getPayments(){
       List<PaymentDetail> payments=paymentrepo.findAll();
        Set<Map> namelist=new HashSet<>();
        for (PaymentDetail payment: payments){
            Map<String, String> msg = new HashMap();
            msg.put("name",payment.getPaymentType());
            namelist.add(msg);
        }
        return namelist;
    }
    public Set<Map> getPaymentName(String paymentType){
        List<PaymentDetail> payments=paymentrepo.getPaymentDetailByPaymentType(paymentType);
        Set<Map> namelist=new HashSet<>();
        for (PaymentDetail payment: payments){
            Map<String, String> msg = new HashMap();
            msg.put("name",payment.getPaymentName());
            namelist.add(msg);
        }
        return namelist;
    }
    public Set<Map> getPaymentAmountByCategoryandPaymentType(String paymentType, String category){
        List<PaymentDetail> payments=paymentrepo.getPaymentDetailByCategory(paymentType,category);
        Set<Map> amount=new HashSet<>();
        for (PaymentDetail payment: payments){
            Map msg = new HashMap();
            msg.put("name",payment.getPaymentName());
            msg.put("value",payment.getAmount());
            amount.add(msg);
        }
        return amount;
    }

}

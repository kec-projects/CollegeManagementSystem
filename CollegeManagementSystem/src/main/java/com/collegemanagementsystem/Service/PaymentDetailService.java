package com.collegemanagementsystem.Service;
import com.collegemanagementsystem.Dto.PaymentDetailDto;
import com.collegemanagementsystem.Dto.PaymentListDto;
import com.collegemanagementsystem.Dto.TransactionHistoryDto;
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

    public Map addpayment(PaymentListDto paymentListDto){

        for(PaymentDetailDto newPaymentListDto: paymentListDto.getPaymentsDetail()){
            PaymentDetail payment=new PaymentDetail();
            payment.setPaymentName(newPaymentListDto.getPaymentName());
            payment.setPaymentType(newPaymentListDto.getPaymentType());
            payment.setCategory(newPaymentListDto.getCategory());
            payment.setAmount(newPaymentListDto.getAmount());
            paymentrepo.save(payment);
        }
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Added successfully");
        return msg;
    }

    public Map DeleteByPaymentType(String paymentType){
         paymentrepo.deleteByPaymentType(paymentType);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Deleted successfully");
        return msg;
    }

    public Map updatePaymentType(String newPaymentType,String oldPaymentType){
        paymentrepo.updatePaymentType(newPaymentType,oldPaymentType);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data Updated successfully");
        return msg;
    }

    public Map DeleteByPaymentTypeAndPaymentName(String paymentType,String paymentName){
         paymentrepo.deleteByPaymentNameAndPaymentType(paymentName,paymentType);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data deleted successfully");
        return msg;
    }
    public Map updatePaymentName(String paymentType,String paymentName){
        paymentrepo.updatePaymentName(paymentType,paymentName);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data updated successfully");
        return msg;
    }

    public Map updateAmount(String paymentType,String paymentName,Double amount){
        paymentrepo.updateAmount(paymentType,paymentName,amount);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data updated successfully");
        return msg;
    }
    public Map updateCategory(String paymentType,String paymentName,String category){
        paymentrepo.updateCategory(paymentType,paymentName,category);
        Map msg=new HashMap();
        msg.put("Status","Successful");
        msg.put("Message","Data updated successfully");
        return msg;
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

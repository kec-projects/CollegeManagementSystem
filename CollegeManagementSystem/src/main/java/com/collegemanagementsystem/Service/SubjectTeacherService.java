package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.SubjectTeacherDto;
import com.collegemanagementsystem.Entity.SubjectTeacherEntity;
import com.collegemanagementsystem.Repository.SubjectTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SubjectTeacherService {
    @Autowired
    private SubjectTeacherRepository subjectTeacherRepository;
    public Map saveSubjectTeacher(SubjectTeacherDto subjectTeacherDto){

        Map msg=new HashMap();
        SubjectTeacherEntity subjectTeacherEntity=new SubjectTeacherEntity();
        subjectTeacherEntity.setTeacherName(subjectTeacherDto.getTeacherName());
        subjectTeacherEntity.setBatch(subjectTeacherDto.getBatch());
        subjectTeacherEntity.setDepart(subjectTeacherDto.getDepart());
        subjectTeacherEntity.setSubName(subjectTeacherDto.getSubName());
        subjectTeacherEntity.setUserId(subjectTeacherDto.getUserId());
        subjectTeacherEntity.setSem(subjectTeacherDto.getSem());
        subjectTeacherEntity.setFlag("active");
        subjectTeacherRepository.save(subjectTeacherEntity);
        msg.put("status","Successful");
        msg.put("msg","Saved Successful");
        return msg;
    }
    public List getSubject(Long userid,String flag){
        return subjectTeacherRepository.getSubject(userid,flag);
    }

    public Map getSubjectDetails(Long classId)
    {
        Map details = new HashMap();
     SubjectTeacherEntity s= subjectTeacherRepository.getOne(classId);
     details.put("Subject Name",s.getSubName());
     details.put("Teacher Name",s.getTeacherName());
     details.put("Branch",s.getDepart());
     details.put("Class Id",s.getClassId());
     details.put("Semester",s.getSem());
     details.put("Teacher UserId",s.getUserId());
     details.put("Batch",s.getBatch());
     return details;
    }
}

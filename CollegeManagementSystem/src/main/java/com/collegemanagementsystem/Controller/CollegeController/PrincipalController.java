package com.collegemanagementsystem.Controller.CollegeController;

import com.collegemanagementsystem.Dto.PrincipalDto;
import com.collegemanagementsystem.Service.interfaceClass.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/college/principal")
public class PrincipalController {
    @Autowired
    PrincipalService principalService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public  Map addPrincipal(@RequestBody @Valid PrincipalDto principalDto)
    {
        return principalService.save(principalDto);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<PrincipalDto> getAll()
    {
        return principalService.principalList();
    }
}

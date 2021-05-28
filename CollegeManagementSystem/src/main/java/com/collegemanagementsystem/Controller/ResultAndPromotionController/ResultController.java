package com.collegemanagementsystem.Controller.ResultAndPromotionController;

import com.collegemanagementsystem.Dto.UserRoleDto;
import com.collegemanagementsystem.Service.ResultAndPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultAndPromotionService resultAndPromotionService;

    @RequestMapping(value = "/generateResult", method = RequestMethod.POST)
    @ResponseBody
    public void resultScraping(@RequestParam String url ,@RequestParam String sem) throws IOException {
        resultAndPromotionService.resultScrap(url,sem);
    }

    @RequestMapping(value = "/promote", method = RequestMethod.POST)
    @ResponseBody
    public void promote(@RequestParam String sem) throws IOException {
        resultAndPromotionService.promote(sem);
    }
    @RequestMapping(value = "/generateResultAndPromote", method = RequestMethod.POST)
    @ResponseBody
    public void resultScrapingAndPromote(@RequestParam String url ,@RequestParam String sem) throws IOException {
        resultAndPromotionService.resultScrap(url,sem);
        resultAndPromotionService.promote(sem);
    }
}

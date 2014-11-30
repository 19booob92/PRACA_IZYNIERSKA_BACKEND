package com.pwr.quizzer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pwr.quizzer.dto.MarkDTO;
import com.pwr.quizzer.service.MarkService;


@Controller
@RequestMapping(value = "/mark" )
public class MarkController {

    @Autowired
    MarkService markService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getTresholds(Model model) {
        model.addAttribute("marks", markService.getModel());
        return "editTresholds";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String updateTresholds(@ModelAttribute("markTresholds") MarkDTO markTresholds, BindingResult result, Model model) {
        markService.updateMark(markTresholds.getTresholdA(), markTresholds.getTresholdB(), markTresholds.getTresholdC(),
                markTresholds.getTresholdD(), markTresholds.getTresholdE());
        return "redirect:/mark";
    }
}

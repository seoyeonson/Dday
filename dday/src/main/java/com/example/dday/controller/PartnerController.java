package com.example.dday.controller;

import com.example.dday.domain.vo.PartnerDTO;
import com.example.dday.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/partner/*")
public class PartnerController {
    private final PartnerService partnerService;

    @GetMapping("/deliveryStatusForm")
    public void deliveryStatusForm(){}

//    @GetMapping("/partner_info")
//    public void partner_info(){}

    @GetMapping(value = {"/partner_info", "/partner_change_info"})
    public void info(Long partnerNumber, Model model){
        model.addAttribute("partner",partnerService.show(1L));
    }

    @GetMapping("/partner_change_info")
    public void partner_change_info(){}

    @PostMapping("/partner_change_info/new")
    public RedirectView newPartner(PartnerDTO partnerDTO, RedirectAttributes redirectAttributes) {
        partnerService.register(partnerDTO);
        redirectAttributes.addFlashAttribute("partnerNumber",partnerDTO.getPartnerNumber());

        return new RedirectView("/partner/partner_change_info");
    }

    @PostMapping("/partner_change_info")
    public RedirectView change(PartnerDTO partnerDTO, RedirectAttributes redirectAttributes){
        partnerService.modify(partnerDTO);
        redirectAttributes.addAttribute("partnerNumber", partnerDTO.getPartnerNumber());
        return new RedirectView("/partner_change_info");
    }

    @GetMapping("/partner_main")
    public void partner_main(){}

    @GetMapping("/partner_management")
    public void partner_management(){}

    @GetMapping("/partner_registration")
    public void partner_registration(){}

    @GetMapping("/partner_shipping")
    public void partner_shipping(){}

    @GetMapping("/partnerProductChange")
    public void partnerProductChange(){}
}

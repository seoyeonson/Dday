package com.example.dday.controller;

import com.example.dday.domain.vo.*;
import com.example.dday.service.PartnerProductService;
import com.example.dday.service.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@Configuration
@Controller
@RequiredArgsConstructor
@RequestMapping("/partner/*")
public class PartnerController {
    private final PartnerService partnerService;
    private final PartnerProductService partnerProductService;

    @GetMapping("/deliveryStatusForm")
    public void deliveryStatusForm() {
    }

//    @GetMapping("/partner_info")
//    public void partner_info(){}

    //    파트너 정보 가져오기
    @GetMapping(value = {"/partner_info", "/partner_change_info"})
    public void info(Long partnerNumber, Model model) {
        model.addAttribute("partner", partnerService.show(1L));
    }

    //     파트너 정보 수정
    @PostMapping("/partner_change_info")
    public RedirectView updateInfo(PartnerDTO partnerDTO, RedirectAttributes redirectAttributes) {
        partnerService.modify(partnerDTO);
        redirectAttributes.addAttribute("partnerNumber", partnerDTO.getPartnerNumber());
        return new RedirectView("/partner/partner_info");
    }

    /*@PostMapping("/partner_intro")
    public RedirectView newPartner(PartnerDTO partnerDTO, RedirectAttributes redirectAttributes) {
        partnerService.register(partnerDTO);
        redirectAttributes.addFlashAttribute("partnerNumber", partnerDTO.getPartnerNumber());

        return new RedirectView("/partner/partner_change_info");
    }*/

    @GetMapping("/partner_main")
    public void partner_main() {
    }

    //    파트너 상품리스트 가져오기

    @GetMapping("/partner_management")
    public void productList(PartnerCriteria partnerCriteria, Model model) {
        log.info("criteria : " + partnerCriteria);
        if (partnerCriteria.getPage() == 0) {

            partnerCriteria.create(1, 2);
        }
        model.addAttribute("products", partnerProductService.showAll(partnerCriteria));
        model.addAttribute("pagination", new PartnerPageDTO().createPageDTO(partnerCriteria, partnerProductService.getTotal()));
    }

    //    상품 정보 가져오기
    @GetMapping("/partnerProductChange")
    public void productInfo(Long productNumber, PartnerCriteria partnerCriteria, Model model) {
        model.addAttribute("partner", partnerProductService.show(productNumber));
    }

    //    상품 추가하기
    @GetMapping("/partner_registration")
    public void productNew(PartnerCriteria partnerCriteria, Model model) {
        model.addAttribute("product", new ProductVO());
    }

    @PostMapping("/partner_registration")
    public RedirectView productNew(PartnerProductDTO partnerProductDTO, RedirectAttributes redirectAttributes) {
        log.info("partnerProductDTO: " + partnerProductDTO.getProductMainImageName());
        partnerProductService.register(partnerProductDTO);
        redirectAttributes.addFlashAttribute("productNumber", partnerProductDTO.getProductNumber());
        return new RedirectView("/partner/partner_management");
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile upload) throws IOException {
        String rootPath = "C:/upload";
        String uploadPath = getUploadPath();
        String uploadFileName = "";
        String productThumbnailName = rootPath + "/";
        String productName = "/";

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        UUID uuid = UUID.randomUUID();
        String fileName = upload.getOriginalFilename();
        uploadFileName = uuid.toString() + "_" + fileName;


        File fullPath = new File(uploadFullPath, uploadFileName);
        upload.transferTo(fullPath);
        log.info("uploadPath: "+uploadPath);

        productThumbnailName += uploadPath;
        productThumbnailName += "/";
        productThumbnailName += uploadFileName;
        log.info("productName: " + productThumbnailName);

        productName += uploadPath;
        productName += "/";
        productName += uploadFileName;

        return productName;
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload", fileName));
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }


    @GetMapping("/partner_shipping")
    public void partner_shipping() {
    }



    //    상품 정보 수정하기
    @PostMapping("/partnerProductChange")
    public RedirectView productChange(PartnerProductDTO partnerProductDTO, RedirectAttributes redirectAttributes) {
        partnerProductService.modify(partnerProductDTO);
        redirectAttributes.addAttribute("productNumber", partnerProductDTO.getProductNumber());
        return new RedirectView("/partner/partner_management");
    }
}
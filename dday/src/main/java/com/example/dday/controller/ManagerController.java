/*
package com.example.dday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/*")
public class ManagerController {
    @GetMapping("/memberAll")
    public void memberAll(){}

    @GetMapping("/memberView")
    public void memberView(){}

}
*/
package com.example.dday.controller;

import com.example.dday.domain.vo.Criteria;
import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.domain.vo.PageDTO;
import com.example.dday.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager/*")
@Slf4j
public class ManagerController {

    // 이 코드가 있어야 밑에서 managerService를 인식해서 Service의 메소드를 쓸 수 있다.
    private final ManagerService managerService;

    //회원 목록
    @GetMapping("/memberAll")
    public void memberAll(Criteria criteria, Model model) {
        if(criteria.getPage() == 0) {
            criteria.create(1,10);
        }

       model.addAttribute("memberInfo", managerService.showAll(criteria));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, managerService.getTotal()));
    }

    // 조건 회원 목록(아디, 이름)
    @GetMapping("/memberAllBy")
    @ResponseBody
    public List<ManagerDTO> memberAllBy(@RequestParam("type") String type,
                                        @RequestParam("keyword") String keyword, Model model, Criteria criteria)throws Exception {
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setType(type);
        managerDTO.setKeyword(keyword);
        return managerService.showAllBy(managerDTO, criteria);
    }

    //탈퇴회원페이지
    @GetMapping("/updateMemberStatus")
    public void updateMemberStatus() {
    }

    //멤버상세페이지
    @GetMapping("/memberView")
    public void memberView(Long memberNumber, Criteria criteria, Model model) {
        model.addAttribute("memberDetail", managerService.showMemberDetail(memberNumber));
    }

}
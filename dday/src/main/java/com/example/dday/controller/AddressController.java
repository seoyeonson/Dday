package com.example.dday.controller;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.soap.addressing.server.annotation.Address;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address/*")
public class AddressController {
    private final AddressService addressService;

    //    추가
    @PostMapping("/new")
    public String write(@RequestBody AddressVO addressVO){
        addressService.save(addressVO);
        return "write success";
    }

    //    전체 조회
    @GetMapping("/list")
    public List<AddressVO> list(HttpSession session){
        return addressService.findAll(((MemberVO)session.getAttribute("member")).getMemberNumber());
    }

//    주소 상태 변경
    @PostMapping("/modify")
    @Transactional(rollbackFor = Exception.class)
    public void modifyStatus(@RequestBody AddressVO addressVO, HttpSession session){
        addressService.setStatusNormal(((MemberVO)session.getAttribute("member")).getMemberNumber());
        addressService.setStatus(addressVO);
    }

    //    주소 삭제
    @DeleteMapping("/{addressNumber}")
    public void remove(@PathVariable Long addressNumber){
        addressService.remove(addressNumber);
    }

}

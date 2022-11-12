package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AppointmentException;
import com.masai.Exception.MemberException;
import com.masai.Model.Appointment;
import com.masai.Model.Member;
import com.masai.Services.AppointmentService;
import com.masai.Services.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
    private MemberService memberService;


    @Autowired
    private AppointmentService appointmentService;


//    @GetMapping("/appointments")
//    public ResponseEntity<List<Appointment>> getVaccineAllAppointment(@RequestParam String key) throws AppointmentException {
//    	 List<Appointment> appts = appointmentService.getAllAppointment();
//        return new ResponseEntity<List<Appointment>>(appts, HttpStatus.FOUND);
//    }

    // member
    @PutMapping("/dose/{memId}")
    public ResponseEntity<Member> updateDoseStatus(@RequestBody Member member, @PathVariable("memId") Integer memId,@RequestParam String key) throws MemberException {
        
    	 Member mem= memberService.updatedoseStatus(member, memId,key);
    	return new ResponseEntity<Member>(mem, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") Integer idCardId,@RequestParam String key) throws MemberException {
    	
    	Member mem = memberService.getMemberById(idCardId,key);
        return new ResponseEntity<Member>(mem, HttpStatus.FOUND);
    }

    @GetMapping("/aadhar/{aadharNo}")
    public ResponseEntity<Member> getMemberByAadhar(@PathVariable("aadharNo") Long aadharNo,@RequestParam String key) throws MemberException {
    	
    	Member mem = memberService.getMemberByAdharNo(aadharNo,key);
    	
    	return new ResponseEntity<Member>(mem, HttpStatus.FOUND);
    }

    @GetMapping("/pan/{panNo}")
    public ResponseEntity<Member> getMemberByPan(@PathVariable("panNo") String panNo,@RequestParam String key) throws MemberException {
        
    	Member mem = memberService.getMemberByPanNo(panNo,key);
    	
    	return new ResponseEntity<Member>(mem, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMemberRecord(@RequestBody Member member,@RequestParam String key) throws MemberException {
        
    	boolean yes = memberService.deleteMemberRecord(member,key);
    	
    	return new ResponseEntity<String>(yes+" Memeber record deleted : ",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member, @PathVariable("id") Integer mId,@RequestParam String key) throws MemberException {
       
    	Member mem = memberService.updateMember(member, mId,key);
    	
    	return new ResponseEntity<Member>(mem, HttpStatus.FOUND);
    }
	
}

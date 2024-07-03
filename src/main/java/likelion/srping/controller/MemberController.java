package likelion.srping.controller;


import likelion.srping.common.CommonResponse;
import likelion.srping.data.domain.Member;
import likelion.srping.data.dto.MemberDTO;
import likelion.srping.data.dto.MemberUpdateDTO;
import likelion.srping.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> joinMember(@RequestBody MemberDTO memberDTO){
        log.info("[MemberController]-[signup] API Call");
        CommonResponse resultJoin = memberService.join(memberDTO);

        return ResponseEntity.status(resultJoin.getStatus()).body(resultJoin);
    }

    @GetMapping(value = "/members")
    public ResponseEntity<CommonResponse> findAllMembers(){
        log.info("[MemberController]-[members] API Call");
        CommonResponse resultFind = memberService.findMembers();

        return ResponseEntity.status(resultFind.getStatus()).body(resultFind);
    }

    @GetMapping("/member/{memberName}")
    public ResponseEntity<CommonResponse> findMember(@PathVariable String memberName){
        log.info("[MemberController]-[memberName] API Call");
        CommonResponse resultFindOne = memberService.findMember(memberName);

        return ResponseEntity.status(resultFindOne.getStatus()).body(resultFindOne);
    }

    @PostMapping("/update")
    public ResponseEntity<CommonResponse> updateMember(@RequestBody MemberUpdateDTO memberUpdateDTO){
        log.info("[MemberController]-[update] API Call");
        CommonResponse resultJoin = memberService.updateMember(memberUpdateDTO);

        return ResponseEntity.status(resultJoin.getStatus()).body(resultJoin);
    }

}

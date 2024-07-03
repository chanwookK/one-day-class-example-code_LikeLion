package likelion.srping.service;


import likelion.srping.common.CommonResponse;
import likelion.srping.data.domain.Member;
import likelion.srping.data.dto.MemberDTO;
import likelion.srping.data.dto.MemberUpdateDTO;
import likelion.srping.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public CommonResponse join(MemberDTO memberDTO) {

        log.info("[MemberService]-[join] 멤버 등록 요청 {}", memberDTO.getName());

        //이미 존재하는 회원이라면 http conflict(409) 를 반환
        if(!validateDuplicateMember(memberDTO)){
            log.info("[MemberService]-[join] 멤버 등록 실패 {}", memberDTO.getName());
            return new CommonResponse(false, HttpStatus.CONFLICT,"이미 존재하는 회원입니다.", null);
        }

        //회원가입 로직 실행
        Member joinMember = memberDTO.toEntity();
        memberRepository.save(joinMember);
        log.info("[MemberService]-[join] 멤버 등록 성공 {}", memberDTO.getName());

        return new CommonResponse(true, HttpStatus.OK, "회원 가입이 완료되었습니다.", memberDTO);


    }

    private boolean validateDuplicateMember(MemberDTO memberDTO) {

        List<Member> byName = memberRepository.findByName(memberDTO.getName());

        //이미 존재하는 회원이라면
        if (!byName.isEmpty())
            return false;
        //존재하지 않는 회원이라면
        else
            return true;
    }



    /**
     * 회원 조회
     */
    public CommonResponse findMembers(){

        List<Member> members = memberRepository.findAll();
        return new CommonResponse(true, HttpStatus.OK, "모든 회원 조회가 완료되었습니다.", members);

    }

    public CommonResponse findMember(String name){

        List<Member> byId = memberRepository.findByName(name);

        if(!byId.isEmpty())
            return new CommonResponse(true, HttpStatus.OK, "이름을 통해 회원 조회가 완료되었습니다.", byId);
        else
            return new CommonResponse(false, HttpStatus.BAD_REQUEST, "회원 조회에 실패했습니다.", null);


    }

    /**
     * 회원 수정
     */
    @Transactional
    public CommonResponse updateMember(MemberUpdateDTO memberUpdateDTO) {

        List<Member> byName = memberRepository.findByName(memberUpdateDTO.getTargetName());
        Member targetMember = byName.get(0);

        targetMember.updateInfo(memberUpdateDTO);

        return new CommonResponse(true, HttpStatus.OK, "정보 수정 성공", targetMember.getId());

    }


}

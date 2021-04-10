package spring.demo.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        Member member = new Member(1L,"woojin", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}

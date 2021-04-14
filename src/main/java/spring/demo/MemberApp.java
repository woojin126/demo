package spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
       /* AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());*/


       ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"woojin",Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println(member1.getName());
        System.out.println(member.getName());
    }
}

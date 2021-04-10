package spring.demo.service;

import spring.demo.Member.Member;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService{

   MemberRepository memberRepository = new MemberRepositoryImpl();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

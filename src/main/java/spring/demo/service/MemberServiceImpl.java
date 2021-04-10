package spring.demo.service;

import spring.demo.Member.Member;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService{

    /*이곳을보면 의존관계가 인터페이스뿐만 아니라 구현까지 의존해버림 */
    private final MemberRepository memberRepository = new MemberRepositoryImpl();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

package spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.demo.Member.Member;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;

@Component
public class MemberServiceImpl implements MemberService{

    /*이곳을보면 의존관계가 인터페이스뿐만 아니라 구현까지 의존해버림 */
    //private final MemberRepository memberRepository = new MemberRepositoryImpl();
    /*OCP,DIP 를 다 지킬수 있는 코드 로 변경
    * 아래 코드 MemberReServiceImpl는 MemberRepositoryImpl 를 의존하지 않는다
    * */
        private final MemberRepository memberRepository;

        @Autowired
        public MemberServiceImpl(MemberRepository memberRepository){
            this.memberRepository=memberRepository;
        }

    public MemberRepository getMemberRepository() { //검증용
        return memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

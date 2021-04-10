package spring.demo.service;

import spring.demo.Member.Member;

public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}

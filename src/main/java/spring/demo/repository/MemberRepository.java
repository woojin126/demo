package spring.demo.repository;

import spring.demo.Member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}

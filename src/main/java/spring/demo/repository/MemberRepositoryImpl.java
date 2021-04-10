package spring.demo.repository;

import spring.demo.Member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryImpl implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
            store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

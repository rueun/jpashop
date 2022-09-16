package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    
    // @PersistenceContext : 스프링 부트가 EntityManager를 주입을 시켜줌
    @PersistenceContext
    private EntityManager em; // JPA를 쓰기 때문에 EntityManager가 필요

    // 저장
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 아이디로 회원 조회
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}

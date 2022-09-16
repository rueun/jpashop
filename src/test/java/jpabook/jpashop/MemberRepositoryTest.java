package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false) // Rollback 하지 않으려면 false 값 설정
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); // 저장한 것이랑 조회한 것이랑 같니 ? 같다.

        // 영속성 컨텍스트에서 (같은 트랜잭션 안에서 저장하고 조회하면 영속성 컨텍스트가 같다.)
        // 같은 영속성 컨텍스트 안에서 아이디가 같으면 같은 엔티티로 식별한다. 식별자가 같으면 같은 엔티티로 인식
        System.out.println("findMember == member " + (findMember == member)); // true

    }

}
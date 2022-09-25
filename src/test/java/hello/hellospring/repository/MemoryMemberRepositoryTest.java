package hello.hellospring.repository;

import java.util.List;

import org.assertj.core.api.Assertions; //assertThat
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;          //assertEquals
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {

        repository.clearStore(); // 테스트 하나씩 실행되고 나서 동작
    }

    @Test
    public void save() {

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // Assertions.assertEquals(result, member);
        Assertions.assertThat(member).isEqualTo(result);

        // System.out.println("result = " + (result == member));
    }

    @Test
    public void fineByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}

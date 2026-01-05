package com.hello.core.member;

import com.hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void before() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join () {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(findMember).isNotNull();
        Assertions.assertThat(findMember.getGrade()).isEqualTo(Grade.BASIC);
    }

}

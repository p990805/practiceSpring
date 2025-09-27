package com.hello.hello.config;

import com.hello.hello.repository.MemberRepository;
import com.hello.hello.repository.MemoryMemberRepository;
import com.hello.hello.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

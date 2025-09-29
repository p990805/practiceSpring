package com.hello.hello.config;

import com.hello.hello.repository.JdbcMemberRepository;
import com.hello.hello.repository.JpaMemberRepository;
import com.hello.hello.repository.MemberRepository;
import com.hello.hello.repository.MemoryMemberRepository;
import com.hello.hello.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}

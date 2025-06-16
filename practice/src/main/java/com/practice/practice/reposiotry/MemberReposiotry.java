package com.practice.practice.reposiotry;

import com.practice.practice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberReposiotry {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String username);
    List<Member> findAll();
}

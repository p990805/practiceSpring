package com.hello.core.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter // 흠 Setter라..
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Grade grade;

}

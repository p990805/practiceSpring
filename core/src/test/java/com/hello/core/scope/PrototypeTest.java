package com.hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        // 프로토 타입은 자동으로 close가 안되기 떄문에 필요하다면 수동으로 close 해준다.
        prototypeBean1.destroy();
        prototypeBean2.destroy();
        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean destroy");
        }
    }

}

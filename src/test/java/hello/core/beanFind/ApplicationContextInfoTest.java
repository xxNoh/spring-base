package hello.core.beanFind;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    @DisplayName("내가 생성한 bean 확인해보기")
    @Test
    void findBean() {
           MemberService memberService = ac.getBean(MemberService.class);
           Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
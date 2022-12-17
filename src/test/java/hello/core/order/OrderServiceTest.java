package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void berforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        // given
        Member member = new Member(1L, "spring", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "toy", 5000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(500);
    }

    @Test
    @DisplayName("discount percent ??")
    void discount_o() {
        AppConfig appConfig = new AppConfig();
        DiscountPolicy discountPolicy = appConfig.discountPolicy();
        Member member = new Member(2L, "spring2", Grade.VIP);
        int discountPrice = discountPolicy.discount(member,5000);
        Assertions.assertThat(discountPrice).isEqualTo(500);
    }
}
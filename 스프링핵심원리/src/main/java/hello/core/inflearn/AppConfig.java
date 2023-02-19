package hello.core.inflearn;

import hello.core.inflearn.discount.DiscountPolicy;
import hello.core.inflearn.discount.FixDiscountPolicy;
import hello.core.inflearn.discount.RateDiscountPolicy;
import hello.core.inflearn.member.*;
import hello.core.inflearn.order.OrderService;
import hello.core.inflearn.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

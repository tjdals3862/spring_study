package hello.core.inflearn;

import hello.core.inflearn.discount.DiscountPolicy;
import hello.core.inflearn.discount.RateDiscountPolicy;
import hello.core.inflearn.member.MemberRepository;
import hello.core.inflearn.member.MemberService;
import hello.core.inflearn.member.MemberServiceImpl;
import hello.core.inflearn.member.MemoryMemberRepository;
import hello.core.inflearn.order.OrderService;
import hello.core.inflearn.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}

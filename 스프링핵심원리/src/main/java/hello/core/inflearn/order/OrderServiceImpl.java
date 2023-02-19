package hello.core.inflearn.order;

import hello.core.inflearn.discount.DiscountPolicy;
import hello.core.inflearn.discount.FixDiscountPolicy;
import hello.core.inflearn.discount.RateDiscountPolicy;
import hello.core.inflearn.member.Member;
import hello.core.inflearn.member.MemberRepository;
import hello.core.inflearn.member.MemberService;
import hello.core.inflearn.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

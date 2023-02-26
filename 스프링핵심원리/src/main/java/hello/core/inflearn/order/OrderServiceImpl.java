package hello.core.inflearn.order;

import hello.core.inflearn.discount.DiscountPolicy;
import hello.core.inflearn.discount.FixDiscountPolicy;
import hello.core.inflearn.discount.RateDiscountPolicy;
import hello.core.inflearn.member.Member;
import hello.core.inflearn.member.MemberRepository;
import hello.core.inflearn.member.MemberService;
import hello.core.inflearn.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 필드 주입
/*
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;
*/


    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    //수정자 주입
/*
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository =  memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy =  discountPolicy;
    }
*/

    // 일반 메서드 주입
    @Autowired
    public void init(MemberRepository memberRepository,DiscountPolicy discountPolicy ) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


// 생성자 주입
    @Autowired
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

package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepositrory;
import hello.core.member.MemoryMemberRepositrory;

public class OrderServiceImpl implements OrderService {

    //인터페이스에만 의존한다. 
    //구체적인 클래스는 전혀 모른다. AppConfig에서 설정한다. 
    private final MemberRepositrory memberRepositrory;
    private final DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepositrory memberRepositrory, DiscountPolicy discountPolicy) {
        this.memberRepositrory = memberRepositrory;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepositrory.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
}

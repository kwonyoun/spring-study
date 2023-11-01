package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepositrory;
import hello.core.member.MemoryMemberRepositrory;

public class OrderServiceImpl implements OrderService {

    private final MemberRepositrory memberRepositrory = new MemoryMemberRepositrory();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepositrory.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
}

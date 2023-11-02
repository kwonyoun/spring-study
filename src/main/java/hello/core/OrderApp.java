package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        // MemberService memberService = new MemberServiceImpl(null);
        // OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 2L;
        Member member = new Member(memberId, "윤진", Grade.Vip);
        memberService.join(member);

        Order order = orderService.creatOrder(memberId, "카메라", 10000);
        

        System.out.println("order = "+ order.toString());
    }
    
}

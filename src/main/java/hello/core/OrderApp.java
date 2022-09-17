package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) { //메인 메소드로 고정 할인 출력 잘 되는지 테스트
// 1       AppConfig appConfig = new AppConfig();
// 1       MemberService memberService = appConfig.memberService();
// 1       OrderService orderService = appConfig.orderService();
        // 스프링 컨테이너 적용 전 코드

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member); //여기까지 멤버 설정 및 등록

        Order order = orderService.createOrder(memberId, "itemA", 10000); //설정한 값으로 최종 생성 주문 반환
        System.out.println("order" + order);
//        System.out.println("order : " + order.calculatePrice()); //아이템과 할인 금액을 뺀 값
    }
}

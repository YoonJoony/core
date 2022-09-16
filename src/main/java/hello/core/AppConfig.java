package hello.core;

import hello.core.discount.RateDiscountPoicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;

public class AppConfig { //어플리케이션 전체를 설정하고 전반 운영을 책임진다
    public MemberService memberService() {
        return new MemberServiceImple(new MemoryMemberRepository()); //DI 의존성 주입
    }

    public OrderService orderService() {
        return  new OrderServiceImple(new MemoryMemberRepository(), new RateDiscountPoicy());
        //orderserviceimple은 저장소, 할인 정책 둘 다 들어가니
    }

}

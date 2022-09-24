package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPoicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable //설정 정보, 애플리케이션이 어떻게 구성되있는지 담당한다.?f
public class AppConfig { //어플리케이션 전체를 설정하고 전반 운영을 책임진다
    /** 리팩토링 하기 전
    public MemberService memberService() {
        return new MemberServiceImple(new MemoryMemberRepository()); //DI 의존성 주입
    }

    public OrderService orderService() {
        return  new OrderServiceImple(new MemoryMemberRepository(), new RateDiscountPoicy());
        //orderserviceimple은 저장소, 할인 정책 둘 다 들어가니
    }
     **/
    @Bean
    public MemberService memberService() {

        return new MemberServiceImple(MemberRepository()); //DI 의존성 주입
    }

    @Bean
    public static MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return  new OrderServiceImple(MemberRepository(), discountPolicy());
        //orderserviceimple은 저장소, 할인 정책 둘 다 들어가니
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

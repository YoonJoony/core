package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPoicy;
import hello.core.member.*;

public class OrderServiceImple implements OrderService{
// 2.   private final MemberRepository memberRepository = new MemoryMemberRepository();
// 2.   //1. private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); --> 고정 할인
// 2.    private final DiscountPolicy discountPolicy = new RateDiscountPoicy(); //1. 역할과 구현을 충실이 분리했지만 OCP, DIP 원칙 위배
//                                                                           //1. OrderService는 인터페이스와 구현체 모두 의존
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImple(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);//할인 정책을 회원을 담아 넘김 - 할인 금액 나옴.
        //할인 변경이 있으면 할민만 고치면 된다. 단일책임 원칙이 잘 설계가 안되고 discountpolice가 없으면 할인이 바뀌면 orderservice도 고쳐야 한다.

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 생성 주문 반환
    }
}

package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;

public class OrderServiceImple implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);//할인 정책을 회원을 담아 넘김 - 할인 금액 나옴.
        //할인 변경이 있으면 할민만 고치면 된다. 단일책임 원칙이 잘 설계가 안되고 discountpolice가 없으면 할인이 바뀌면 orderservice도 고쳐야 한다.

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 생성 주문 반환
    }
}

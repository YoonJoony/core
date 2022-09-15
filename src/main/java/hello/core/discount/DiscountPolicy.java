package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price); //멤버(등급)와 할인 대상 금액 파라미터 넘김.

    //@return 할인 대상 금액
}

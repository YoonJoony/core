package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; //할인 금액
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) { //객체를 받아 등급이 VIP먄 1000원 리턴
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}

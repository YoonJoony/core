package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPoicyTest { //10퍼 할인 테스트
    RateDiscountPoicy discountPoicy = new RateDiscountPoicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되엉 한다") //JUnit5 디스플레이 네임 ? 한글로 이름을 쓸 수가 있다
    void vip_o() {
        Member member = new Member(1l, "memberVIP", Grade.VIP);
        //when
        int discount = discountPoicy.discount(member, 10000); //vip 일시 10퍼 할인되므로 1000원이 들어간다
        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아닌 경우 적용 되지 않아야 함")
    void vip_x() {
        Member member = new Member(1l, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPoicy.discount(member, 10000); //vip가 아니면 할인값은 0원이다.
        //then
        assertThat(discount).isEqualTo(1000); //discount = 0;

    }
}
package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    //최종 오더 결과를 반환한다.


}

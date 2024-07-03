package likelion.srping.service;


import jakarta.transaction.Transactional;
import likelion.srping.common.CommonResponse;
import likelion.srping.data.domain.Delivery;
import likelion.srping.data.domain.Member;
import likelion.srping.data.domain.Order;
import likelion.srping.data.domain.OrderItem;
import likelion.srping.data.domain.item.Item;
import likelion.srping.data.enumType.DeliveryStatus;
import likelion.srping.repository.ItemRepository;
import likelion.srping.repository.MemberRepository;
import likelion.srping.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 상품 주문
     * 
     */
    @Transactional
    public CommonResponse itemOrder(String memberName, String itemName, int count){

        Member member = memberRepository.findByName(memberName).get(0);
        
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.PENDING);
        
        Item item = itemRepository.findByName(itemName).get(0);
        
        //OrderItem과 item 의 연관관계 설정
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //Order와 OrderItem의 연관관계 설정 및 Order와 Member, Delivery와 연관관계 설정
        Order newOrder = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(newOrder);

        return new CommonResponse(true, HttpStatus.OK, "주문 성공", newOrder.getId());

    }


}

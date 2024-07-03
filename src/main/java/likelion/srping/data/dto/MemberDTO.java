package likelion.srping.data.dto;


import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import likelion.srping.data.domain.Address;
import likelion.srping.data.domain.Member;
import likelion.srping.data.domain.Order;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MemberDTO {

    private Long id;

    private String name;

    private Address address;

    private List<Order> orders = new ArrayList<>();

    public Member toEntity(){
        return new Member(this.id, this.name, this.address, this.orders);

    }

}

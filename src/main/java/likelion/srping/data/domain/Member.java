package likelion.srping.data.domain;


import jakarta.persistence.*;
import likelion.srping.data.dto.MemberDTO;
import likelion.srping.data.dto.MemberUpdateDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


    //비즈니스 로직
    public Member updateInfo(MemberUpdateDTO memberDTO){
        if(memberDTO.getName() != null)
            this.name = memberDTO.getName();
        if(memberDTO.getAddress() != null)
            this.address = memberDTO.getAddress();
        return this;
    }
}

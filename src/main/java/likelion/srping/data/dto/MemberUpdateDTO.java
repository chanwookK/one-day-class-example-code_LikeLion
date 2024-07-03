package likelion.srping.data.dto;

import likelion.srping.data.domain.Address;
import lombok.Data;

@Data
public class MemberUpdateDTO {

    private String targetName;
    private String name;
    private Address address;

}

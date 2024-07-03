package likelion.srping.data.dto;


import lombok.Data;

@Data
public class OrderRequestDTO {

    private String memberName;
    private String itemName;
    private int count;

}

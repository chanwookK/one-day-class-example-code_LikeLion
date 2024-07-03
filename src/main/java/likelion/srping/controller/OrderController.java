package likelion.srping.controller;


import likelion.srping.common.CommonResponse;
import likelion.srping.data.dto.OrderRequestDTO;
import likelion.srping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<CommonResponse> order(@RequestBody OrderRequestDTO orderRequestDTO) {

        CommonResponse result = orderService.itemOrder(orderRequestDTO.getMemberName(), orderRequestDTO.getItemName(), orderRequestDTO.getCount());
        return ResponseEntity.status(result.getStatus()).body(result);

    }
}

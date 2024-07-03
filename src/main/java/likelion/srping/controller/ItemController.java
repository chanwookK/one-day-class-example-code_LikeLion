package likelion.srping.controller;


import likelion.srping.common.CommonResponse;
import likelion.srping.data.dto.ItemDTO;
import likelion.srping.data.dto.MemberDTO;
import likelion.srping.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @PostMapping("/add-item")
    public ResponseEntity<CommonResponse> registItem(@RequestBody ItemDTO itemDTO){

        CommonResponse resultAdd = itemService.addItem(itemDTO);

        return ResponseEntity.status(resultAdd.getStatus()).body(resultAdd);
    }

    @GetMapping(value = "/items")
    public ResponseEntity<CommonResponse> findAllItems(){

        CommonResponse resultFind = itemService.findItems();

        return ResponseEntity.status(resultFind.getStatus()).body(resultFind);
    }

    @GetMapping("/item/{itemName}")
    public ResponseEntity<CommonResponse> findItem(@PathVariable String itemName){

        CommonResponse resultFindOne = itemService.findItem(itemName);

        return ResponseEntity.status(resultFindOne.getStatus()).body(resultFindOne);
    }

}

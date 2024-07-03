package likelion.srping.service;

import likelion.srping.common.CommonResponse;
import likelion.srping.data.domain.Member;
import likelion.srping.data.domain.item.Album;
import likelion.srping.data.domain.item.Book;
import likelion.srping.data.domain.item.Item;
import likelion.srping.data.domain.item.Movie;
import likelion.srping.data.dto.ItemDTO;
import likelion.srping.data.dto.MemberDTO;
import likelion.srping.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;


    /**
     * 상품 등록
     */
    @Transactional
    public CommonResponse addItem(ItemDTO itemDTO) {

        //이미 존재하는 회원이라면 http conflict(409) 를 반환
        if (!validateDuplicateMember(itemDTO)) {
            return new CommonResponse(false, HttpStatus.CONFLICT, "이미 존재하는 상품입니다.", null);
        }

        //회원가입 로직 실행
        Item addItem = itemDTO.toEntity();
        itemRepository.save(addItem);

        return new CommonResponse(true, HttpStatus.OK, "상품 등록이 완료되었습니다.", itemDTO);


    }

    private boolean validateDuplicateMember(ItemDTO itemDTO) {

        List<Item> byName = itemRepository.findByName(itemDTO.getName());

        //이미 존재하는 회원이라면
        if (!byName.isEmpty())
            return false;
            //존재하지 않는 회원이라면
        else
            return true;
    }

    /**
     * 상품 조회
     */
    public CommonResponse findItems() {

        List<Item> items = itemRepository.findAll();
        return new CommonResponse(true, HttpStatus.OK, "모든 상품 조회가 완료되었습니다.", items);

    }

    public CommonResponse findItem(String name) {

        List<Item> byId = itemRepository.findByName(name);

        if (!byId.isEmpty())
            return new CommonResponse(true, HttpStatus.OK, "이름을 통한 상품 조회가 완료되었습니다.", byId);
        else
            return new CommonResponse(false, HttpStatus.BAD_REQUEST, "상품 조회에 실패했습니다.", null);


    }




}

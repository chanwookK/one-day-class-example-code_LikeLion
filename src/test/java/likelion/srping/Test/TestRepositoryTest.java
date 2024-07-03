package likelion.srping.Test;

import jakarta.transaction.Transactional;
import likelion.srping.data.dto.ItemDTO;
import likelion.srping.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
class TestRepositoryTest {

    @Autowired
    TestRepository tr;

    @Autowired
    ItemService itemService;

    @Test
    @Transactional
    @Rollback(false)
    public void test() {

        TestEntity te = new TestEntity();
        TestEntity te2 = new TestEntity();
        te.setName("강찬욱");
        te2.setName("곽민재");

        Long id1 = tr.save(te);
        Long id2 = tr.save(te2);

        System.out.println(tr.find(id1).getName());
        System.out.println(tr.find(id2).getName());

    }

    @Test
    @Transactional
    @Rollback(false)
    public void test2() {
        ItemDTO book = new ItemDTO();
        book.setDtype("B");
        book.setName("book1");
        book.setPrice(1);
        book.setStockQuantity(1);
        book.setAuthor("author1");
        book.setIsbn("1");

        itemService.addItem(book);

        ItemDTO book2 = new ItemDTO();
        book2.setDtype("B");
        book2.setName("book2");
        book2.setPrice(2);
        book2.setStockQuantity(2);
        book2.setAuthor("author2");
        book2.setIsbn("2");



    }


}
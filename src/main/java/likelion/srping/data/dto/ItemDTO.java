package likelion.srping.data.dto;

import likelion.srping.data.domain.item.Album;
import likelion.srping.data.domain.item.Book;
import likelion.srping.data.domain.item.Item;
import likelion.srping.data.domain.item.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    private String artist;
    private String etc;

    private String author;
    private String isbn;

    private String director;
    private String actor;

    private String dtype;

    public Item toEntity(){
       if (this.dtype.equals("A")) {
            Album album = new Album(artist, etc);
            return setFields(album);
        }
        else if (this.dtype.equals("B")) {
            Book book = new Book(author, isbn);
            return setFields(book);
        }
        else if (this.dtype.equals("M")) {
            Movie movie = new Movie(director, actor);
            return setFields(movie);
        }
        else
            return null;

    }

    private Item setFields(Item item){
        item.setId(id);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        return item;
    }

}

package library;

import com.github.pagehelper.PageInfo;
import entities.Book;
import library.mapper.BookMapper;
import library.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BookControllerTest
 * @Description
 * @Date 2019/11/2 12:08
 * @Author Alex
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {
    @Autowired
    BookMapper bookMapper;
    @Resource
    BookService bookService;

    @Test
    public void getBooksBySortId(){
        Book book = new Book();
        book.setsBookName("水浒传");
        List<Book> list = bookMapper.books(book);
    }

    @Test
    public void page(){
//        PageInfo<Book> bookPageInfo = bookService.page(1,2);
//        System.out.println(bookPageInfo);
    }

}

package library.interf;

import com.github.pagehelper.PageInfo;
import entities.*;
import library.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookInterface
 * @Description
 * @Date 2019/11/9 9:07
 * @Author Alex
 * @Version 1.0
 **/
public interface BookInterface {
    PageInfoLayui<Book> books(Book book, Integer pageNum, Integer pageSize);//根据book中的部分字段查看书籍
    PageInfoLayui<Book> getBooksByStuId(String type,String sStuId,Integer pageNum,Integer pageSize);//根据type:borrow-未还 return-已还，查看学生借阅的书
    PageInfoLayui<Ticket> bills(String type, String sStuId,Integer pageNum,Integer pageSize);//根据type:borrow-当前账单， return-历史账单
    PageInfoLayui<Student> getBorrowBookCountOfStudent(String type,String sStuId, Integer pageNum,Integer pageSize);//根据type borrow-当前学生借书统计 handle-学生诚信度为0
    PageInfoLayui<Book> getStudentBooks(String type,String sStuId,Integer pageNum,Integer pageSize);//老师查学生未还/逾期书籍，根据type borrow-当前未还 overdue-当前逾期
    PageInfoLayui<Student> getLoseIntegrityStudents(String sStuId,Integer pageNum,Integer pageSize);//获取失信学生
    PageInfoLayui<Ticket> getBills(String sStuId,Integer pageNum,Integer pageSize);//获取学生逾期账单
    PageInfoLayui<Ticket> getBillsDetail(String sStuId,Integer pageNum,Integer pageSize);//获取某个学生账单详情
}

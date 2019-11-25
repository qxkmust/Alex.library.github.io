package library.mapper;

import entities.*;

import java.util.List;

/**
 * @ClassName BookMapper
 * @Description
 * @Date 2019/11/2 11:23
 * @Author Alex
 * @Version 1.0
 **/
public interface BookMapper {
    Book book(String sBookId);//根据id查看书籍
    List<Book> books(Book book);//根据book中的部分字段查看书籍
    List<Book> getBooksByStuId(String type,String sStuId);//根据type:borrow-未还 return-已还，查看学生借阅的书
    Borrow getBookByStuId(Book book);//查找某本书
    Integer borrow(Borrow borrow);//借书
    List<BookSort> booksort();//获取图书分类
    Integer delay(Borrow borrow);//延期还书
    List<Ticket> bills(String type, String sStuId);//根据type获取学生账单，borrow-当前账单，return-历史账单
    Integer updateBook(Book book);//修改书籍信息
    Integer addBook(Book book);//添加书籍
    Student student(String sStuId);//查看学生信息
    List<Student> getBorrowBookCountOfStudent(String type,String sStuId);//根据type borrow-当前学生借书统计 handle-学生诚信度为0
    List<Book> getStudentBooks(String type,String sStuId);//老师查学生未还/逾期书籍，根据type borrow-当前未还 overdue-当前逾期
    Integer resetStudentIntegrity(String sStuId);//老师恢复学生的诚信级别
    List<Student> getLoseIntegrityStudents(String sStuId);//获取失信学生
    List<Ticket> getBills(String sStuId);//获取学生逾期账单
    Integer getStudentOverdueNum(String sStuId);//获取学生逾期次数
    List<Ticket> getBillsDetail(String sStuId);//获取某个学生账单详情
}

package library.service;

import com.github.pagehelper.PageHelper;
import entities.*;
import library.interf.BookInterface;
import library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookService
 * @Description
 * @Date 2019/11/9 8:44
 * @Author Alex
 * @Version 1.0
 **/
@Service
public class BookService implements BookInterface {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfoLayui<Ticket> getBillsDetail(String sStuId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Ticket> billsDetail = bookMapper.getBillsDetail(sStuId);
        PageInfoLayui<Ticket> ticketPageInfoLayui = new PageInfoLayui<Ticket>(billsDetail);
        return ticketPageInfoLayui;
    }

    @Override
    public PageInfoLayui<Ticket> getBills(String sStuId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Ticket> bills = bookMapper.getBills(sStuId);
        PageInfoLayui<Ticket> ticketPageInfoLayui = new PageInfoLayui<Ticket>(bills);
        return ticketPageInfoLayui;
    }

    @Override
    public PageInfoLayui<Student> getLoseIntegrityStudents(String sStuId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = bookMapper.getLoseIntegrityStudents(sStuId);
        PageInfoLayui<Student> studentPageInfoLayui = new PageInfoLayui<Student>(students);
        return studentPageInfoLayui;
    }

    @Override
    public PageInfoLayui<Book> getStudentBooks(String type, String sStuId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.getStudentBooks(type, sStuId);
        PageInfoLayui<Book> bookPageInfoLayui = new PageInfoLayui<Book>(books);
        return bookPageInfoLayui;
    }

    @Override
    public PageInfoLayui<Student> getBorrowBookCountOfStudent(String type, String sStuId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = bookMapper.getBorrowBookCountOfStudent(type,sStuId);
        PageInfoLayui<Student> studentPageInfo = new PageInfoLayui<Student>(students);
        return studentPageInfo;
    }

    @Override
    public PageInfoLayui<Book> books(Book book, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.books(book);
        PageInfoLayui<Book> bookPageInfo = new PageInfoLayui<Book>(books);
        return bookPageInfo;
    }

    @Override
    public PageInfoLayui<Book> getBooksByStuId(String type, String sStuId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.getBooksByStuId(type,sStuId);
        PageInfoLayui<Book> bookPageInfo = new PageInfoLayui<Book>(books);
        return bookPageInfo;
    }

    @Override
    public PageInfoLayui<Ticket> bills(String type, String sStuId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Ticket> bills = bookMapper.bills(type,sStuId);
        PageInfoLayui<Ticket> billPageInfo = new PageInfoLayui<Ticket>(bills);
        return billPageInfo;
    }
}

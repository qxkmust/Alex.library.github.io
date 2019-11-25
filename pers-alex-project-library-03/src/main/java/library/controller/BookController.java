package library.controller;

import entities.*;
import library.mapper.BookMapper;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.ClassAnnotation;
import utils.MethodAnnotation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Description
 * @Date 2019/11/2 11:23
 * @Author Alex
 * @Version 1.0
 **/
@Controller
@ClassAnnotation(msg = "书籍业务控制层")
public class BookController {
     @Autowired
    private HttpServletRequest request;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    /**
     * 跳转到学生图书借阅页面
     */
    @GetMapping("/student/books")
    public String books(){
        return "student/book/list";
    }

    /**
     * 请求图书分页数据
     */
    @ResponseBody
    @GetMapping("/books/get")
    public String books(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize)
    {
        PageInfoLayui<Book> books = bookService.books(null,pageNum,pageSize);
        return PageInfoLayui.jsonStr(books);
    }

    /*
    * 查阅书籍
    * */
    @ResponseBody
    @GetMapping("/book/search")
    public String search(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                         Book book) {
        PageInfoLayui<Book> books = bookService.books(book,pageNum,pageSize);
        return PageInfoLayui.jsonStr(books);
    }

    /*
     * 跳转到学生图书管理页面GET
     * */
    @GetMapping("/student/manage")
    public String manage(){
        return "student/manage/list";
    }

    /*
    * 处理学生图书管理查询
    * */
    @ResponseBody
    @GetMapping("/student/manage/get")
    public String manage(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                         @RequestParam(name="type",defaultValue = "borrow") String type){
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            PageInfoLayui<Book> books = bookService.getBooksByStuId(type,loginUser.getsUsername(),pageNum,pageSize);
            return PageInfoLayui.jsonStr(books);
        }
        return PageInfoLayui.jsonStr("");
    }

    /*
    * 跳转到查看/申请借书延期页面
    * */
    @GetMapping("/student/manage/{sBookId}")
    public String delay(Map<String,Object> mp,
                        @PathVariable("sBookId") String sBookId,
                        @RequestParam(name="type",defaultValue = "view")String type){
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            Borrow book = bookMapper.getBookByStuId(new Borrow(loginUser.getsUsername(), sBookId));
            mp.put("book",book);
        }
        return "student/manage/"+type;
    }

    /*
    * 学生申请延期还书
    * */
    @PutMapping("/student/manage/delay")
    public String delay(Borrow borrow){
        bookMapper.delay(borrow);
        return "redirect:/student/manage";
    }

    /*
    * 获取书籍分类
    * */
    @ResponseBody
    @GetMapping("/booksort")
    public List<BookSort> booksort(){
        return bookMapper.booksort();
    }

    /*
    * 跳转book 查看书本/借阅书本页面
    * */
    @GetMapping("/student/book/{sBookId}")
    public String book(@PathVariable("sBookId") String sBookId,
                       @RequestParam(name="type",defaultValue="view") String type,
                       Map<String,Object> mp){
        Book book = bookMapper.book(sBookId);
        mp.put("book",book);
        return "student/book/"+type;
    }

    /*
    *  借书
    * */
    @PostMapping("/borrow")
    @MethodAnnotation(msg = "学生{0}借书-{1}",keys = {"#borrow.sStuId","#borrow.sBookId"})
    public String borrow(Borrow borrow){
        bookMapper.borrow(borrow);
        return "redirect:/student/books";
    }

   /*
   * Get跳转到账单页面
   * */
    @GetMapping("/student/bills")
    public String bills(){
        return "student/bill/list";
    }

    /*
     * Post处理账单分类查询
     * */
    @ResponseBody
    @GetMapping("/student/bills/get")
    public String bills(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                        @RequestParam(name="type",defaultValue = "borrow")String type){
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            PageInfoLayui<Ticket> bills = bookService.bills(type, loginUser.getsUsername(),pageNum,pageSize);
            return PageInfoLayui.jsonStr(bills);
        }
        return PageInfoLayui.jsonStr("");
    }


//    以下为老师系统控制层

    /*
    * 跳转到老师系统图书管理页面
    * */
    @GetMapping("/teacher/books")
    public String teacher_books(){
        return "teacher/book/list";
    }

    /*
     * 查看书籍信息
     * */
    @ResponseBody
    @GetMapping("/book/{sBookId}")
    public Book book(@PathVariable("sBookId") String sBookId){
        return bookMapper.book(sBookId);
    }

    /*
    * 跳转到书籍查看/修改页面
    * */
    @GetMapping("/teacher/book/{sBookId}")
    public String teacher_book(@PathVariable("sBookId")String sBookId,
                               @RequestParam(name="type",defaultValue = "view")String type,
                               Map<String,Object> mp){
        Book book = bookMapper.book(sBookId);
        mp.put("book",book);
        return "teacher/book/"+type;
    }
    /*
    * 修改书籍
    * */
    @PutMapping("/teacher/book/update")
    @MethodAnnotation(msg = "修改书籍-{0}信息",keys ={"#book.sBookName"})
    public String update(Book book){
        bookMapper.updateBook(book);
        return "redirect:/teacher/books";
    }

    /*
     * 跳转到老师系统新增图书页面
     * */
    @GetMapping("/teacher/books/add")
    public String add(){
        return "teacher/book/add";
    }

    /*
    * 老师新增书籍
    * */
    @PostMapping("/teacher/book/add")
    @MethodAnnotation(msg = "新增书籍",keys = {"#book.sBookName"})
    public String add(Book book){
        bookMapper.addBook(book);
        return "redirect:/teacher/books";
    }
    /*
    * 查看学生信息
    * */
    @ResponseBody
    @GetMapping("/student/{sStuId}")
    public Student student(@PathVariable("sStuId")String sStuId){
        return bookMapper.student(sStuId);
    }

    /*
    * 跳转到学生管理页面
    * */
    @GetMapping("/teacher/students")
    public String students(){
        return "teacher/student/list";
    }

    /*
    * 获取学生管理页面数据
    * */
    @ResponseBody
    @GetMapping("/teacher/students/get")
    public String students(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                           @RequestParam(name="type",defaultValue = "borrow")String type,
                           @RequestParam(name="sStuId",required = false)String sStuId,
                           Map<String,Object>mp){
        PageInfoLayui<Student> students = bookService.getBorrowBookCountOfStudent(type,sStuId,pageNum,pageSize);
        mp.put("type",type);
        students.setExtra(mp);
        return PageInfoLayui.jsonStr(students);
    }

    /*
    * 跳转到学生管理>>未还图书页面
    * */
    @GetMapping("/teacher/student/borrow/{sStuId}")
    public String borrow(@PathVariable("sStuId")String sStuId,
                               Map<String,Object> mp){
        mp.put("sStuId",sStuId);
        return "teacher/student/borrow";
    }

    /*
     * 跳转到学生管理>>已逾期图书页面
     * */
    @GetMapping("/teacher/student/overdue/{sStuId}")
    public String overdue(@PathVariable("sStuId")String sStuId,
                               Map<String,Object> mp){
        mp.put("sStuId",sStuId);
        return "teacher/student/overdue";
    }

    /*
    * 老师查询学生借阅/逾期的书籍
    * */
    @ResponseBody
    @GetMapping("/teacher/student/books/{sStuId}")
    public String borrow_books(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                               @PathVariable("sStuId")String sStuId,
                               @RequestParam(name="type",defaultValue = "borrow") String type){
        PageInfoLayui<Book> books = bookService.getStudentBooks(type, sStuId, pageNum, pageSize);
        return PageInfoLayui.jsonStr(books);
    }

    /*
    * 跳转到失信处理页面
    * */
    @GetMapping("/teacher/student/integrity")
    public String integrity(){
        return "teacher/student/integrity";
    }

    /*
     * 获取失信学生列表
     * */
    @ResponseBody
    @GetMapping("/teacher/student/lose_integrity")
    public String integrity(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                            @RequestParam(name="sStuId",required = false)String sStuId){
        PageInfoLayui<Student> students = bookService.getLoseIntegrityStudents(sStuId, pageNum, pageSize);
        return PageInfoLayui.jsonStr(students);
    }

    /*
    * 获取学生逾期次数
    * */
    @ResponseBody
    @GetMapping("/teacher/student/overdue_num/{sStuId}")
    public Integer overdue(@PathVariable("sStuId")String sStuId){
        return bookMapper.getStudentOverdueNum(sStuId);
    }

    /*
    * 若当前无欠费记录，可手动恢复失信学生诚信等级
    * */
    @GetMapping("/teacher/student/reset_integrity/{sStuId}")
    @MethodAnnotation(msg = "手动恢复学生{0}诚信等级",keys = {"#sStuId"})
    public String reset_integrity(@PathVariable("sStuId")String sStuId){
        bookMapper.resetStudentIntegrity(sStuId);
        return "redirect:/teacher/student/integrity";
    }

    /*
    * 老师查看学生逾期账单
    * */
    @ResponseBody
    @GetMapping("/teacher/student/bills")
    public String teacher_bills(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                                @RequestParam(name="sStuId",required = false)String sStuId){
        PageInfoLayui<Ticket> bills = bookService.getBills(sStuId, pageNum, pageSize);
        return PageInfoLayui.jsonStr(bills);
    }

    /**
     * 跳转到账单页面
     */
    @GetMapping("/teacher/bills")
    public String teacher_bills(){
        return "teacher/bill/list";
    }

    /*
    * 跳转到学生逾期详情页面
    * */
    @GetMapping("/teacher/student/detail_overdue/{sStuId}")
    public String detail_overdue(@PathVariable("sStuId")String sStuId,
                                 Map<String,Object> mp){
        mp.put("sStuId",sStuId);
        return "teacher/bill/overdue";
    }

    /*
     * 老师查看学生账单详情
     * */
    @ResponseBody
    @GetMapping("/teacher/student/detail_bills/{sStuId}")
    public String detail_bills(@RequestParam(name="pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(name="pageSize",defaultValue = "5")Integer pageSize,
                        @PathVariable("sStuId")String sStuId,
                        Map<String,Object> mp){
        PageInfoLayui<Ticket> bills = bookService.getBillsDetail(sStuId,pageNum,pageSize);
        mp.put("sStuId",sStuId);
        bills.setExtra(mp);
        return PageInfoLayui.jsonStr(bills);
    }

}

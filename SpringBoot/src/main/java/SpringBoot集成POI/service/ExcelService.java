package SpringBoot集成POI.service;

import SpringBoot集成POI.dao.BookMapper;
import SpringBoot集成POI.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/9
 * @version: 1.0
 */
@Service
public class ExcelService
{
    @Autowired
    BookMapper bookMapper;
    public List<Book> getAllBooks()
    {
        return bookMapper.getAllBooks();
    }

    public boolean addBook(List<Book> list)
    {
        return bookMapper.addBook(list);
    }
}


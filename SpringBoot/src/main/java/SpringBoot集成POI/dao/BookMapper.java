package SpringBoot集成POI.dao;

import SpringBoot集成POI.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper
{
    List<Book> getAllBooks();

    boolean addBook(List<Book> list);
}


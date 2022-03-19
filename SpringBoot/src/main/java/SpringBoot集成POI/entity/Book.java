package SpringBoot集成POI.entity;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/9
 * @version: 1.0
 */
public class Book
{
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
    private String db_source;

    @Override
    public String toString()
    {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", detail='" + detail + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }

    public Integer getBookID()
    {
        return bookID;
    }

    public void setBookID(Integer bookID)
    {
        this.bookID = bookID;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public Integer getBookCounts()
    {
        return bookCounts;
    }

    public void setBookCounts(Integer bookCounts)
    {
        this.bookCounts = bookCounts;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDb_source()
    {
        return db_source;
    }

    public void setDb_source(String db_source)
    {
        this.db_source = db_source;
    }
}


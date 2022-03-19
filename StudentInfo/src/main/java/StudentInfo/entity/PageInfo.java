package StudentInfo.entity;

import java.util.List;

public class PageInfo {
    private boolean hasPreviousPage;//上一页
    private boolean hasNextPage;//下一页
    private List<Integer> navigatepageNums;//页码
    private Integer pages;//总页数
    private Integer pageNum;//当前页数
    private Integer total;//总条数

    @Override
    public String toString() {
        return "PageInfo{" +
                "hasPreviousPage=" + hasPreviousPage +
                ", hasNextPage=" + hasNextPage +
                ", navigatepageNums=" + navigatepageNums +
                ", pages=" + pages +
                ", pageNum=" + pageNum +
                ", total=" + total +
                '}';
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<Integer> getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public PageInfo(boolean hasPreviousPage, boolean hasNextPage, List<Integer> navigatepageNums, Integer pages, Integer pageNum, Integer total) {
        this.hasPreviousPage = hasPreviousPage;
        this.hasNextPage = hasNextPage;
        this.navigatepageNums = navigatepageNums;
        this.pages = pages;
        this.pageNum = pageNum;
        this.total = total;
    }

    public PageInfo() {
    }
}

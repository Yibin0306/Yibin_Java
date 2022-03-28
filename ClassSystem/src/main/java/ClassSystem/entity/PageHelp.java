package ClassSystem.entity;

public class PageHelp {
    private int page=1;
    private int pagenum=10;
    private int start;
    private int end;

    public PageHelp() {
    }

    public PageHelp(int page, int pagenum, int start, int end) {
        this.page = page;
        this.pagenum = pagenum;
        this.start = start;
        this.end = end;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "PageHelp{" +
                "page=" + page +
                ", pagenum=" + pagenum +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

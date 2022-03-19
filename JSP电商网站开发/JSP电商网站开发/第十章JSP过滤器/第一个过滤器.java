package 第十章JSP过滤器;

import jakarta.servlet.*;

import java.io.IOException;

public class 第一个过滤器 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("开始部署");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("部署中....");
        //放行，通知请求向下传递，继续进行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("部署结束");
    }
}

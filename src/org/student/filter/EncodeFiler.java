package org.student.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public class EncodeFiler implements Filter {
    //设置字符集格式
    String code = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//获取web.xml中的初始参数
        String encode=filterConfig.getInitParameter("encode");
        //如果没有设置字符集格式则使用web.xml中的字符集格式
        if (this.code==null){
            this.code=encode;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//获取字符格式
        String encode=servletRequest.getCharacterEncoding();
        if (encode==null){
            servletRequest.setCharacterEncoding(this.code);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
this.code=null;
    }
}

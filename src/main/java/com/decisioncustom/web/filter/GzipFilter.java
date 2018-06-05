package com.decisioncustom.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class GzipFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        MyHttpServletResponse resp=new MyHttpServletResponse((HttpServletResponse) response);

        chain.doFilter(request, resp);

        ByteArrayOutputStream baout=resp.getBaout();
        byte[] srcBytes=baout.toByteArray();
        System.out.println("srcBytes的长度："+srcBytes.length);
        ByteArrayOutputStream baout2=new ByteArrayOutputStream();
        GZIPOutputStream gzip=new GZIPOutputStream(baout2);
        gzip.write(srcBytes);
        gzip.close();

        byte[] destBytes=baout2.toByteArray();
        HttpServletResponse httpResp=(HttpServletResponse) response;
        httpResp.setHeader("Content-Encoding", "gzip");
        httpResp.setContentLength(destBytes.length);
        httpResp.getOutputStream().write(destBytes);
    }

    @Override
    public void destroy() {
    }

}
class MyHttpServletResponse extends HttpServletResponseWrapper {
    private ByteArrayOutputStream baout;
    public MyHttpServletResponse(HttpServletResponse response) {
        super(response);
        baout=new ByteArrayOutputStream();
    }
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new MyOutputStream3(baout);
    }
    PrintWriter pw=null;
    @Override
    public PrintWriter getWriter() throws IOException {
        pw=new PrintWriter(new OutputStreamWriter(baout, "utf-8"),true);
        return pw;
    }
    public ByteArrayOutputStream getBaout(){
        if(pw!=null){
            pw.close();
        }
        return baout;
    }
}
class MyOutputStream3 extends ServletOutputStream{
    private ByteArrayOutputStream baout;
    public MyOutputStream3(ByteArrayOutputStream baout) {
        this.baout=baout;
    }

    @Override
    public void write(int b) throws IOException {
        baout.write(b);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }
}
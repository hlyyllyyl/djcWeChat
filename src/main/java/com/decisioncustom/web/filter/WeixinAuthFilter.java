package com.decisioncustom.web.filter;

import com.alibaba.fastjson.JSONObject;
import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.service.ICustomerService;
import com.decisioncustom.wexin.HttpClientUtil;
import com.decisioncustom.wexin.WeixinConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebFilter("/*") //所有地址都能被Filter拦截
public class WeixinAuthFilter implements Filter {

    @Autowired
    private ICustomerService customerService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
        /*System.out.println("过滤器初始化");*/
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpServletResponse hResponse = (HttpServletResponse) response;
        //如果session中已经存在微信号了，就不用获取了，否则要获取，获取到以后要存放sesion
        String fromUserName = (String) hRequest.getSession().getAttribute("fromUserName");
        if (fromUserName == null)
        {
        	String agent = hRequest.getHeader("User-Agent");
        	  //只有在微信端才做里面的操作
            if (agent != null && agent.toLowerCase().indexOf("micromessenger") >= 0)
            {
                String code = request.getParameter("code");
                String state = request.getParameter("state");
                //如果code不为空，scope为base,scope为userInfo代表用户已经同意
                if (code != null && state != null && state.equals("1"))
                {
                	System.out.println("1111111111111");
                    // 通过Code获取openid来进行授权
                    String url =  WeixinConstants.AUTH_GET_OID.replace("APPID",WeixinConstants.getProperty("APPID"))
                    		.replace("SECRET", WeixinConstants.getProperty("APPSECRET"))
                    		.replace("CODE", code);
                    String json = HttpClientUtil.httpGet(url);
                    String openid = JSONObject.parseObject(json).getString("openid");

                    hRequest.getSession().setAttribute("fromUserName", openid);
                    String accessToken = JSONObject.parseObject(json).getString("access_token");
                    /*String url2= "https://api.weixin.qq.com/sns/auth?access_token="+accessToken+"&openid="+openid;*/
                    String url1 = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openid+"&lang=zh_CN";
                    String json1 = HttpClientUtil.httpGet(url1);
                    String json2 = new String(json1.getBytes("ISO-8859-1"), "UTF-8");

                   TCustomer customer= new TCustomer();
                        String nickname = JSONObject.parseObject(json2).getString("nickname");
                        String province = JSONObject.parseObject(json2).getString("province");
                        String city = JSONObject.parseObject(json2).getString("city");

                        if(JSONObject.parseObject(json2).getString("headimgurl")!=null && !JSONObject.parseObject(json2).getString("headimgurl").equals("")){
                            String headimgurl = JSONObject.parseObject(json2).getString("headimgurl").replace("\\/","/");
                            customer.setWxHeadImg(headimgurl);
                            System.out.print(nickname+province+city+headimgurl);
                        }
                    customer.setWechatName(nickname);
                    customer.setCity(city);
                    customer.setProvince(province);
                    customer.setFromUserName(openid);
                    hRequest.getSession().setAttribute("customer",customer);
                }
                else
                {
                	System.out.println("2222222222222222");
                	  //发送用户同意的请求
                    String path = hRequest.getRequestURL().toString();
                    String query = hRequest.getQueryString();
                    if (query != null)
                    {
                        path = path + "?" + query;
                    }
                    String uri = WeixinConstants.AUTH_URL.replace("APPID", WeixinConstants.getProperty("APPID"))
                    		.replace("REDIRECT_URI", URLEncoder.encode(path, "UTF-8"))
                            .replace("SCOPE", "snsapi_userinfo").replace("STATE", "1");

                    hResponse.sendRedirect(uri);
                    return;
                }
            }
        }
        chain.doFilter(hRequest, hResponse);
    }

	@Override
	public void destroy() {
        /*System.out.println("过滤器销毁");*/
    }

}

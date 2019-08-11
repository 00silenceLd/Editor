package swtech.facade.pageDesign.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpRequst {
	public static void main(String[] args) {
		HttpRequst http=new HttpRequst();
		http.test();
	}
	  public void test(){
          CookieStore cookieStore = new BasicCookieStore();
          HttpClientContext localContext = new HttpClientContext();
          CloseableHttpClient httpclient = HttpClients.createDefault();
          localContext.setCookieStore(cookieStore);
          HttpPost httppost = new HttpPost("https://sso.zxxk.com/login");
          List<NameValuePair> formParams = new ArrayList<NameValuePair>();
          formParams.add(new BasicNameValuePair("username", "kzkjyxgs"));
          formParams.add(new BasicNameValuePair("password", "648980"));
          try {
              UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
              httppost.setEntity(entity);
              // 提交登录数据
              HttpResponse re = httpclient.execute(httppost, localContext);
              EntityUtils.toString(re.getEntity());
              // 获取cookie
              List<Cookie> cook = cookieStore.getCookies();
              for(Cookie c:cook){
                  //设置cookie
                  BasicClientCookie cookie = new BasicClientCookie(c.getName(), c.getValue());   
                    cookie.setVersion(0);    
                    cookie.setDomain("gang666.top");   //设置范围  
                    cookie.setPath("/");   
                    cookieStore.addCookie(cookie); 
              }
               // 构造一个新的get请求，用来测试登录是否成功
              HttpGet newGet = new HttpGet("http://zujuan.xkw.com/");
              re = httpclient.execute(newGet, localContext);
              EntityUtils.toString(re.getEntity());
          } catch (UnsupportedEncodingException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (ClientProtocolException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
  }
}

package tests.EE;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws IOException {
        HttpClient http = null;
        CookieStore httpCookieStore = new BasicCookieStore();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);
        http = builder.build();

        HttpPost httpPost = new HttpPost("https://sandbox.theexoduseffect.com/login");
        HttpResponse httpResponse = null;
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("redir", "members"));
        params.add(new BasicNameValuePair("username", "qa+signin@redhotmarketingllc.com"));
        params.add(new BasicNameValuePair("password", "gtakgxck"));
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        httpResponse = http.execute(httpPost);
        System.out.println(httpResponse.getStatusLine());
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://sandbox.theexoduseffect.com/members");
        for (Cookie cookie : httpCookieStore.getCookies()) {
            System.out.println(httpCookieStore.getCookies());
            org.openqa.selenium.Cookie driverCookie = new org.openqa.selenium.Cookie(
                    cookie.getName(),
                    cookie.getValue(),
                    cookie.getDomain(),
                    cookie.getPath(),
                    cookie.getExpiryDate(),
                    true
            );
            System.out.println(driverCookie);
            driver.manage().addCookie(driverCookie);
        }
    }
}

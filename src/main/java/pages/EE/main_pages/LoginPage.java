package pages.EE.main_pages;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameTextbox = By.id("username");
    By passwordTextbox = By.id("password");
    By submitButton = By.id("submitButton");

    public void loginPage(String baseUrl){
        driver.get(baseUrl + "login" + propertyManager.getProperty("testingKey", "EE"));
        logger.info("Log In page loaded");
    }

    public void signIn(){
        writeText(usernameTextbox, propertyManager.getProperty("email", "EE"));
        writeText(passwordTextbox, propertyManager.getProperty("password", "EE"));
        click(submitButton);
        logger.info("Sign in form loaded");
    }

    public void signIn(String email, String password){
        writeText(usernameTextbox, email);
        writeText(passwordTextbox, password);
        click(submitButton);
        logger.info("Sign in form loaded");
    }

    public void signInAPI() throws IOException {
        HttpClient http = null;
        CookieStore httpCookieStore = new BasicCookieStore();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);
        http = builder.build();

        HttpPost httpPost = new HttpPost("https://sandbox.theexoduseffect.com/login");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("redir", "members"));
        params.add(new BasicNameValuePair("username", "qa+signin@redhotmarketingllc.com"));
        params.add(new BasicNameValuePair("password", "gtakgxck"));
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse httpResponse = null;
        try {httpResponse = http.execute(httpPost);} catch (Throwable error) {throw new RuntimeException(error);}

        List<Cookie> cookies = httpCookieStore.getCookies();
        System.out.println(cookies);
//        for (Cookie cookie : cookies) {
//            driver.manage().addCookie(cookie);
//        }



//        HttpClient httpclient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(baseURL + "api/sessions");
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("email", email));
//        params.add(new BasicNameValuePair("password", password));
//        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//        HttpResponse response = httpclient.execute(httpPost);
//
//        Header[] headers = response.getHeaders("set-cookie");
//        ArrayList<Cookie> cookies = new ArrayList<Cookie>();
//        for (Header header : headers) {
//            String[] headerValues = header.getValue().split(";");
//            Cookie floCookie = new Cookie(
//                    headerValues[0].split("=")[0],
//                    headerValues[0].split("=")[1],
//                    headerValues[0].split("=")[0].equals("crumb") ? "auth.qav2.researchbinders.com" : "qav2.researchbinders.com",
//                    "/",
//                    new Date(headerValues[2].split("=")[1]),
//                    true
//            );
//            cookies.add(floCookie);
//        }
//        driver.get("#/app/select-team");
//        for (Cookie cookie : cookies) {
//            driver.manage().addCookie(cookie);
//        }
    }
}

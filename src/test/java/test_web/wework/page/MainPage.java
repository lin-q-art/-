package test_web.wework.page;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class MainPage {
    public static ChromeDriver driver = null;
    public MainPage(){
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();
        //driver.manage().deleteAllCookies();
        try {
            FileReader fileReader =new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line=bufferedReader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String Domain = tokenizer.nextToken();
                String Path = tokenizer.nextToken();
                //如何把string转为date
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if(!dt.equals("null")){

                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    expiry = sdf.parse(dt);
                }
                //把string转化为成boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name,value,Domain,Path,expiry,isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        driver.get(url);
    }

    public ContactPage toContact(){
        //todo:
        driver.findElementByCssSelector("#menu_contacts").click();
        return new ContactPage();
    }
}

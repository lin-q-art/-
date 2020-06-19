package test_web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class TestSelenium {
    WebDriver driver;

   @Test
    public void TestSelenium() throws IOException, InterruptedException {
        ChromeOptions options =new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver();
       loadCookie(driver);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
       Thread.sleep(15000);

       //获取cookie
       // driver.manage().getCookies();
        //cookie 处理
        //driver.manage().addCookie("");
       //cookie支取一条进行处理
   }
    public void loadCookie(WebDriver driver){
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

                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
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
    }

    public void saveCookie(WebDriver driver) {
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(("cookie.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                //进行保存

                bufferedWriter.write(cookie.getName() + ';' +
                        cookie.getValue() + ';' +
                        cookie.getDomain() + ';' +
                        cookie.getPath() + ';' +
                        cookie.getExpiry() + ';' +
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

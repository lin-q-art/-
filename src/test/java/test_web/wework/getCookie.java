package test_web.wework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class getCookie {
    WebDriver driver;
    @Test
    public void getCookies(){
        ChromeOptions options =new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver(options);
        try
        {
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
        } catch(
                IOException e)

        {
            e.printStackTrace();
        }
    }


}

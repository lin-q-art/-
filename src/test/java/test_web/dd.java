package test_web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class dd {
   @Test
    public void testHelloWorld() throws Exception {
        //开启个浏览器并且输入链接
        String url = "https://www.baidu.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        //得到浏览器的标题
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        //关闭浏览器 下面是关闭所有标签页，还有一个代码是 driver.close();, 关闭当前标签页
        driver.quit();


    }

    }


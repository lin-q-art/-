import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestDemoTest {
    private WebDriver driver;
    @Before
    public  void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //利用chromedriver控制chrome
        driver = new ChromeDriver(options);
    }
    @Test
    public  void testDemo(){
        driver.findElement(new By.ByCssSelector(".index_service_cnt_itemWrap")).click();

    }
}


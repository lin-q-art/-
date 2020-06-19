package test_web.wework.page;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
public class MainPage {
    public static ChromeDriver driver;
    public MainPage(){
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan","zh"));
        driver.manage().addCookie(new Cookie("wwrtx.ref","direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid","02576774"));
        driver.manage().addCookie(new Cookie("ww_rtkey","7981205698"));
        driver.manage().addCookie(new Cookie("_ga","GA1.2.1818737593.1591022581"));
        driver.manage().addCookie(new Cookie("_gid","GA1.2.1927191492.1591022581"));
        driver.manage().addCookie(new Cookie("_gat","1"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st","a8675107"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","AJqZFf5tMgpOTfx3eYIGM0smb2uPsFPf8USNb9p_Qst0UFFMjBpHy4bNTLmLLW91"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype","1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid","1970325139131104"));
        driver.manage().addCookie(new Cookie("wxpay.vid","1688850921775182"));
        driver.manage().addCookie(new Cookie("wwrtx.vst","IMwcS-R2CKyhXLmsTz1Vfuw3orziYHY2LwmmDEDMmcx_LEIrm-OdsKvuDg0B3K_eRunLEzG5EOWYJ1AgQPAcUZTehGMcTINGrjB54JR79L9B6pZ0JnrIK3p1YLZmaLLHvqSglJr8OChmi3qln4VVoTB3MQRy7RuM8PhLXdLngyFhl4H0ynY8yiD-nZj2_Kuzx2GfTecSVRlNV9YGky2fJcOKKkKaUvFYgBdKYYGCpKk05wpDwVKUVqV_TaMlqdLEn8hlFfHWktmS8vVMNdHwTQ"));
        driver.manage().addCookie(new Cookie("wwrtx.vid","1688850921775182"));
        driver.manage().addCookie(new Cookie("wwrtx.logined","true"));





    }

    public ContactPage toContact(){
        //todo:
        driver.findElementByCssSelector("#menu_contacts").click();
        return new ContactPage();
    }
}

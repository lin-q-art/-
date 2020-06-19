package test_web.wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.linkText("删除");

    public ContactPage addMember(String username, String acctid, String mobile) throws InterruptedException {
        //当点击添加成员后，页面未渲染出username,while判断为假，继续点击会导致报错：无法找到”添加成员“元素---需要在后面添加等待
        while(MainPage.driver.findElements(this.username).size()==0){
            MainPage.driver.findElement(addMember).click();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        MainPage.driver.findElement(this.username).sendKeys(username);
        MainPage.driver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.driver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }

    public ContactPage search(String keyword) throws InterruptedException {
        Thread.sleep(3000);
        MainPage.driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        new WebDriverWait(MainPage.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(delete));
        return this;
    }

    public ContactPage delete() throws InterruptedException {
        Thread.sleep(3000);
        MainPage.driver.findElement(delete).click();
        MainPage.driver.findElement(By.linkText("确认")).click();
        MainPage.driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}

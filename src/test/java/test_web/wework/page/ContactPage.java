package test_web.wework.page;

import org.openqa.selenium.By;

public class ContactPage {
    public ContactPage addMember(String username, String acctid, String mobile){
        //todo:
        MainPage.driver.findElement(By.linkText("添加成员")).click();
        MainPage.driver.findElement(By.name("username")).sendKeys("5");
        MainPage.driver.findElement(By.name("acctid")).sendKeys("5");
        MainPage.driver.findElement(By.name("mobile")).sendKeys("15996435825");
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }
}

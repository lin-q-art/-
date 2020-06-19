package test_web.wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_web.wework.page.ContactPage;
import test_web.wework.page.MainPage;

public class TestContact {
    static MainPage main;
    static ContactPage contact;

    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
        contact=main.toContact();
    }

    @Test
    void testAddMember() throws InterruptedException {
        contact.addMember("5","5","15996465306");
        //todo:assert
    }

    @Test
    void testSearch() throws InterruptedException {
        contact.search("5").delete();
    }

    @AfterAll
    static void afterAll() throws InterruptedException {
        Thread.sleep(20000);
        MainPage.driver.quit();
    }
}

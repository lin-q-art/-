package test_web.wework.testcase;

import org.junit.jupiter.api.Test;
import test_web.wework.page.MainPage;

public class TestContact {
    @Test
    void testAddMember(){
        MainPage main = new MainPage();
        main.toContact().addMember("5","5","15996465306");
        //todo:assert

    }
}

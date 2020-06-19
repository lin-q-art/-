package junit5;

        import org.junit.jupiter.api.Tag;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    @Tag("")
    void div() {
        Calc calc = new Calc();
        assertEquals(calc.div(2,1),2);
    }
}
package junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAssertion {

    @Test
    void assertion(){
        assertAll("demo assertions",
                ()-> assertEquals( 1,2 ),
                ()->assertEquals( 1,1),
                ()->assertEquals( 1,3)
        );
    }
}

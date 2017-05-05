import org.junit.Test;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class BraceTest {
    @Test
    public void additionalBrace_1(){
        assertEquals("You input string contains incorrect brace sequence",
                Main.minimaize("(asdasd (asdasd )")
                );
    }
    @Test
    public void additionalBrace_2(){
        assertEquals("You input string contains incorrect brace sequence",
                Main.minimaize("(werwer)AND ewrwer)")
        );
    }

    @Test
    public void additionalBrace_3(){
        assertEquals("You input string contains incorrect brace sequence",
                Main.minimaize("(((asdasdads))OR (asdasdasd)()()()))")
        );
    }
    @Test
    public void additionalBrace_4(){
        assertEquals("You input string contains incorrect brace sequence",
                Main.minimaize("(a ANB b")
        );
    }
    @Test
    public void additionalBrace_5(){
        assertEquals("NOT b",
                Main.minimaize("(  NOT b  )")
        );
    }
    @Test
    public void additionalBrace_6(){
        assertEquals("NOT TRUE",
                Main.minimaize("(  NOT TRUE  )")
        );
    }
}

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
                Main.minimaize("(a AND b")
        );
    }
    @Test
    public void additionalBrace_5(){
        assertEquals("Expression contains brace around operations is incorrect",
                Main.minimaize("(NOT  )OR (a AND b)")
        );
    }

    @Test
    public void additionalBrace_6(){
        assertEquals("Expression contains brace around operations is incorrect",
                Main.minimaize("((A AND B)OR (OR  )AND (a AND b)AND C)")
        );
    }

    @Test
    public void additionalBrace_7(){
        assertEquals("Expression contains brace around operations is incorrect",
                Main.minimaize("((A AND B)AND (A OR B (((AND)))OR C  )AND (a AND b)AND C)")
        );
    }

}

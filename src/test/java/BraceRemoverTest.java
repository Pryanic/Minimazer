import org.junit.Test;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class BraceRemoverTest {
    @Test
    public void removeBrace_1(){
        assertEquals("You input empty string",
                Main.minimaize("( ( ))")
        );
    }
    @Test
    public void removeBrace_2(){
        assertEquals("You input empty string",
                Main.minimaize("(())()()(()()())")
        );
    }
    @Test
    public void removeBrace_3(){
        assertEquals("You input empty string",
                Main.minimaize("((((())()))()(()()()))")
        );
    }

    @Test
    public void removeBrace_4(){
        assertEquals("You input empty string",
                Main.minimaize("((()))()()((()))((()()((()()))))")
        );
    }
}

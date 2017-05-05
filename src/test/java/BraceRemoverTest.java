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
        assertEquals("Incorrect sequence of brace",
                Main.minimaize("( ( ))")
        );
    }
    @Test
    public void removeBrace_2(){
        assertEquals("Incorrect sequence of brace",
                Main.minimaize("((a AND b))()()(()()())")
        );
    }
    @Test
    public void removeBrace_3(){
        assertEquals("Incorrect sequence of brace",
                Main.minimaize("((((())()))()(()()()))")
        );
    }

    @Test
    public void removeBrace_4(){
        assertEquals("Incorrect sequence of brace",
                Main.minimaize("(((D AND C)))(A OR B)(D OR F)OR(((K AND T)))((()()((()()))))")
        );
    }
    @Test
    public void removeBrace_5(){
        assertEquals("Incorrect sequence of brace",
                Main.minimaize("()()")
        );
    }

    @Test
    public void removeBrace_6(){
        assertEquals("Incorrect sequence of brace",
                Main.minimaize("((()))()")
        );
    }

    @Test
    public void removeBrace_7(){
        assertEquals("Expression contains brace around operations is incorrect",
                Main.minimaize("(A AND B)NOT (x OR Y)")
        );
    }
}

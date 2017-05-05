import org.junit.Test;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */

public class EmptyStringTest {

    @Test
    public void emptyStringTest(){
        assertEquals("You input empty string", Main.minimaize(""));
    }

    @Test
    public void stringContainsOnlySpaces1(){
        assertEquals("You input string which contains only spaces",Main.minimaize("         "));
    }
    @Test
    public void stringContainsOnlySpaces2(){
        assertEquals("You input string which contains only spaces",Main.minimaize(" "));
    }
    @Test
    public void spacesRemoverTest_1(){
        assertEquals("((a AND B) AND C OR D)",Main.minimaize("( (a AND B) AND C OR D )"));
    }

    @Test
    public void spacesRemoverTest_2(){
        assertEquals("((a AND B) AND C OR D)OR NOT C",Main.minimaize("( (     a AND B ) AND C OR D   )OR NOT C"));
    }
}

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
        assertEquals("a AND b AND c OR d",Main.minimaize("( (a AND b) AND c OR d )"));
    }

    @Test
    public void spacesRemoverTest_2(){
        assertEquals("a AND b AND c OR c OR d",Main.minimaize("( (     a AND b ) AND c OR d   )OR  c"));
    }
}

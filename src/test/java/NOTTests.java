import org.junit.Test;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;
/**
 * Created by ihladush on 09.05.17.
 */
public class NOTTests {
    @Test
    public void simpleTest1(){
        assertEquals("NOT(b) OR a",Main.minimaize("a OR NOT b"));
    }
    @Test
    public void simpleTest2(){
        assertEquals("TRUE",Main.minimaize("a OR NOT a"));
    }

    @Test
    public void simpleTest3(){
        assertEquals("TRUE",Main.minimaize("NOT a OR  a"));
    }
    @Test
    public void simpleTest4(){
        assertEquals("FALSE",Main.minimaize("NOT TRUE"));
    }
    @Test
    public void simpleTest5(){
        assertEquals("TRUE",Main.minimaize("NOT NOT TRUE"));
    }

    @Test
    public void simpleTest6(){
        assertEquals("TRUE",Main.minimaize("NOT FALSE"));
    }
    @Test
    public void simpleTest7(){
        assertEquals("FALSE",Main.minimaize("NOT NOT FALSE"));
    }

    @Test
    public void simpleTest8(){
        assertEquals("NOT(b) AND a",Main.minimaize("a AND NOT b"));
    }
    @Test
    public void simpleTest9(){
        assertEquals("FALSE",Main.minimaize("a AND NOT a"));
    }

    @Test
    public void simpleTest10(){
        assertEquals("FALSE",Main.minimaize("NOT a AND  a"));
    }
    @Test
    public void simpleTest11(){
        assertEquals("NOT(x) OR NOT(y)",Main.minimaize("NOT (x AND y)"));
    }

    @Test
    public void simpleTest12(){
        assertEquals("NOT(x) AND NOT(y)",Main.minimaize("NOT (x OR y)"));
    }
}

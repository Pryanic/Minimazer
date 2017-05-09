import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;
/**
 * Created by ihladush on 09.05.17.
 */
public class AndOrBrace {
    @Test
    public void simpleTest1(){
        assertEquals("a OR b",Main.minimaize("(a OR b)"));
    }
    @Test
    public void simpleTest2(){
        assertEquals("a OR b OR c",Main.minimaize("(a OR b) OR c    "));
    }
    @Test
    public void simpleTest3(){
        assertEquals("a AND b",Main.minimaize("(a AND b)"));
    }
    @Test
    public void simpleTest4(){
        assertEquals("a AND b AND c",Main.minimaize("(a AND b) AND c    "));
    }
    @Test
    public void simpleTest5(){
        assertEquals("(a OR b) AND c",Main.minimaize("(a OR b) AND c    "));
    }
    @Test
    public void simpleTest6(){
        assertEquals("(a OR b) AND (c OR d)",Main.minimaize("(a OR b) AND (c OR d)    "));
    }
    @Test
    public void simpleTest7(){
        assertEquals("a OR b",Main.minimaize("(a OR b) AND (a OR b)    "));
    }
    @Test
    public void simpleTest8(){
        assertEquals("a OR b",Main.minimaize("(a OR b) AND TRUE    "));
    }
    @Test
    public void simpleTest9(){
        assertEquals("FALSE",Main.minimaize("(a OR b) AND FALSE    "));
    }

    @Test
    public void simpleTest10(){
        assertEquals("a AND b",Main.minimaize("((a AND b) OR FALSE )AND((b AND a))"));
    }
    @Test
    public void simpleTest11(){
        assertEquals("a OR b",Main.minimaize("((a OR b) AND TRUE )OR((b OR a))"));
    }
    @Test
    public void simpleTest12(){
        assertEquals("a OR b",Main.minimaize("((a OR b) AND FALSE )OR((b OR a))"));
    }
    @Test
    public void simpleTest13(){
        assertEquals("c OR d",Main.minimaize("c OR c AND c OR d"));
    }

    @Test
    public void simpleTest14(){
        assertEquals("a AND c OR d",Main.minimaize("(c OR (c AND FALSE))AND a OR d"));
    }
}

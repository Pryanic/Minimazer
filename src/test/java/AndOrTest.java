import org.junit.Test;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;
/**
 * Created by ihladush on 08.05.17.
 */
public class AndOrTest {
    @Test
    public void simpleTest1(){
        assertEquals("a OR b",Main.minimaize("a OR b"));
    }
    @Test
    public void simpleTest2(){
        assertEquals("a OR b OR c",Main.minimaize("a OR b OR c    "));
    }
    @Test
    public void simpleTest21(){
        assertEquals("TRUE",Main.minimaize("a OR b OR TRUE    "));
    }

    @Test
    public void simpleTest3(){
        assertEquals("a AND b",Main.minimaize("a AND b"));
    }
    @Test
    public void simpleTest4(){
        assertEquals("a AND b AND c",Main.minimaize("a AND b AND c    "));
    }
    @Test
    public void simpleTest5(){
        assertEquals("a OR b AND c",Main.minimaize("a OR b AND c    "));
    }

    @Test
    public void simpleTest6(){
        assertEquals("FALSE",Main.minimaize("a AND FALSE AND c    "));
    }
    @Test
    public void simpleTest7(){
        assertEquals("TRUE",Main.minimaize("a OR b OR TRUE    "));
    }
    @Test
    public void simpleTest8(){
        assertEquals("a AND c",Main.minimaize("a AND TRUE AND c    "));
    }
    @Test
    public void simpleTest9(){
        assertEquals("a OR b",Main.minimaize("a OR b OR FALSE    "));
    }
    @Test
    public void simpleTest10(){
        assertEquals("a",Main.minimaize("a AND a    "));
    }
    @Test
    public void simpleTest11(){
        assertEquals("a",Main.minimaize("a OR a   "));
    }
    @Test
    public void simpleTest12(){
        assertEquals("a OR b",Main.minimaize("a OR a OR TRUE AND b  "));
    }
    @Test
    public void simpleTest13(){
        assertEquals("TRUE",Main.minimaize("a OR TRUE OR a AND b  "));
    }
    @Test
    public void simpleTest14(){
        assertEquals("a",Main.minimaize("a AND TRUE    "));
    }
    @Test
    public void simpleTest15(){
        assertEquals("a",Main.minimaize("a OR FALSE   "));
    }
}

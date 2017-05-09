import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.stepic.hladush.Main;

import static org.junit.Assert.assertEquals;
/**
 * Created by ihladush on 05.05.17.
 */
public class AllowedCharactersTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void notAllowedCharacterUpperLetterTest(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("Z AND TRUE"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
    @Test(expected = IllegalArgumentException.class)
    public void notAllowedCharacterTest2(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("(a AND TRUE) OR ($ OR vanya)"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
    @Test(expected = IllegalArgumentException.class)
    public void notAllowedCharacterTest3() throws Exception{
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("(a AND TRUE) OR (sa OR vanya) # vanya"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
    @Test(expected = IllegalArgumentException.class)
    public void notAllowedCharacterTest4(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("((D AND TRUE) OR (sa OR vanya) # vanya)"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spacesRemoverTest_1(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("( (a AND B) AND C OR D )"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spacesRemoverTest_2(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("( (     a AND B ) AND C OR D   )OR NOT C"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
    @Test(expected = IllegalArgumentException.class)
    public void spacesRemoverTest_3(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("( (     a AND b ) AND c AND F OR d   )OR NOT c"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
    @Test(expected = IllegalArgumentException.class)
    public void spacesRemoverTest_4(){

        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("F FALSE"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
    @Test(expected = IllegalArgumentException.class)
    public void spacesRemoverTest_5(){

                Main.minimaize("FALSEFALSE");

    }
    @Test(expected = IllegalArgumentException.class)
    public void spacesRemoverTest_6(){
        assertEquals("Not allowed value (. Only small characters allowed",
                Main.minimaize("TRUEFALSE"));
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Not allowed value (. Only small characters allowed");
    }
}

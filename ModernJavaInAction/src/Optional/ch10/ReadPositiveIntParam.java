package Optional.ch10;

import static org.junit.Assert.assertEquals;

import java.util.Properties;
import org.junit.Test;

public class ReadPositiveIntParam {

    @Test
    public void testMap() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
        assertEquals(0, readDurationImperative(props, "b"));
        assertEquals(0, readDurationImperative(props, "c"));
        assertEquals(0, readDurationImperative(props, "d"));

//        assertEquals(5, readDurationWithOptional(props, "a"));
//        assertEquals(0, readDurationWithOptional(props, "b"));
//        assertEquals(0, readDurationWithOptional(props, "c"));
//        assertEquals(0, readDurationWithOptional(props, "d"));
    }

    public int readDurationImperative(Properties props, String name){
        String value = props.getProperty(name);
        if (value!=null){
            try{
                int i = Integer.parseInt(value);
                if (i>0){
                    return i;
                }
            }catch (NumberFormatException nfe){}
        }
    return 0;} //하나의 조건이라도 실패하면 0반환
}



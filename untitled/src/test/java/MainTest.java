import org.junit.Test;
import org.junit.Assert;

import static org.example.Main.UznatAge;

public class MainTest {
    @Test
    public void UznatageTest() {
        Assert.assertEquals("ребенок", UznatAge(6));
        Assert.assertEquals("ребенок", UznatAge(10));
        Assert.assertEquals("взрослый", UznatAge(25));
        Assert.assertEquals("старик", UznatAge(55));
        Assert.assertEquals("старик", UznatAge(70));
        Assert.assertEquals("старик", UznatAge(-12));


    }
}
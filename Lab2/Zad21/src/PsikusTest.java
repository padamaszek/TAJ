import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PsikusTest {

    private Psikus psikus = new Psikus();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //cyfrokrad Tests
    @Test
    public void cyfrokradNotNullReturn() {
        Assert.assertNotNull(psikus.cyfrokrad(123));
    }

    @Test
    public void cyfrokradReturnNull() {
        Assert.assertNull(psikus.cyfrokrad(5));
    }

    @Test
    public void cyfrokradRemoveofOneNumber() {
        Assert.assertEquals(2, psikus.cyfrokrad(169).toString().length());
    }

    //chujtajchochla Test
    @Test
    public void testHultajchochla() throws Exception {


    }

    //Nieksztaltek Tests:
    @Test
    public void nieksztaltekSameNumberNothingToSwap() {
        Assert.assertEquals(124, psikus.nieksztaltek(124).intValue());
    }

    @Test
    public void nieksztaltekDiffrentNumberSwap() {
        Assert.assertNotEquals(136, psikus.nieksztaltek(136).intValue());
    }

}
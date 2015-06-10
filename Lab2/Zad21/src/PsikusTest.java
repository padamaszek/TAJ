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
    public void hultajchochlaException() throws NieudanyPsikusException {
        thrown.expect(NieudanyPsikusException.class);
        psikus.hultajchochla(1);
    }
    @Test
    public void hultajchochlaReturnDifferentNumber() throws NieudanyPsikusException {
        Assert.assertNotEquals(1345, psikus.hultajchochla(1345).intValue());
    }

    //Nieksztaltek Tests:
    @Test
    public void nieksztaltekSameNumberNothingToSwap() {
        Assert.assertEquals(215, psikus.nieksztaltek(215).intValue());
    }

    @Test
    public void nieksztaltekDiffrentNumberSwap() {
        Assert.assertNotEquals(326, psikus.nieksztaltek(326).intValue());
    }

}
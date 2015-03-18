/**
 * Created by Hunter on 2015-03-18.
 */
package com.game.test;

import com.game.code.NieudanyPsikusException;
import com.game.code.Psikus;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class PsikusTest {

    private Psikus psikus = new Psikus();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //cyfrokrad Tests
    @Test
    public void cyfrokradNotNullReturn() {
        Assert.assertNotNull(psikus.cyfrokrad(123).intValue());
    }

    @Test
    public void cyfrokradReturnNull() {
        Assert.assertNull(psikus.cyfrokrad(5));
    }

    @Test
    public void cyfrokradRemoveofOneNumber() {
        Assert.assertEquals(2, psikus.cyfrokrad(169).toString().length());
    }

    @Test
    public void cyfrokradLengthOfThree() {
        Assert.assertEquals(3, psikus.cyfrokrad(1694).toString().length());
    }

    //chujtajchochla Test
//   @Test
//    public void hultajchochlaException() throws NieudanyPsikusException {
//        thrown.expect(NieudanyPsikusException.class);
//        psikus.hultajchochla(1);
//    }

    @Test
    public void hultajchochlaDiffNumber() throws NieudanyPsikusException {
        Assert.assertNotSame(13246, psikus.hultajchochla(12346).toString());
    }

    //Nieksztaltek Tests:
    @Test
    public void nieksztaltekDiffrentResult() {
        Assert.assertThat(psikus.nieksztaltek(367).intValue(), is(anyOf(equalTo(867), equalTo(361), equalTo(397))));
    }

    @Test
    public void nieksztaltekSameNumberNothingToSwap() {
        Assert.assertEquals(124, psikus.nieksztaltek(124).intValue());
    }

    @Test
    public void nieksztaltekDiffrentNumberSwap() {
        Assert.assertNotEquals(136, psikus.nieksztaltek(136).intValue());
    }

    @Test
    public void nieksztaltekOnlySwap() {
        Assert.assertNotSame(376, psikus.nieksztaltek(376).intValue());
    }


}
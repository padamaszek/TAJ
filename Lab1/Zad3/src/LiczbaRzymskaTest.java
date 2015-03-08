/**
 * Created by Hunter on 2015-03-08.
 */

    import org.junit.Assert;
    import org.junit.Test;
    public class LiczbaRzymskaTest {
        private LiczbaRzymska rzymska;

        @Test
        public void CorrectToRoman() {
            rzymska = new LiczbaRzymska(3999);
            Assert.assertEquals("MMMCMXCIX", rzymska.toString());
        }
        @Test
        public void NegativeNumber() {
            rzymska = new LiczbaRzymska(-20);
            Assert.assertNotNull(rzymska);
        }
        @Test
        public void Zero() {
            rzymska = new LiczbaRzymska(0);
            Assert.assertNotNull(rzymska);
        }
        @Test
        public void BelowWarning() {
            rzymska = new LiczbaRzymska(0);
            Assert.assertEquals("Insert Integer between 1 and 9999", rzymska.toString());
        }
        @Test
        public void AboveWarning() {
            rzymska = new LiczbaRzymska(4200);
            Assert.assertEquals("Insert Integer between 1 and 9999", rzymska.toString());
        }

}

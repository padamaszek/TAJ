import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Hunter on 2015-04-15.
 */
public class DummyMsgServiceTest {
    private Messenger messenger;

    @Before
    public void Init() {
        messenger = new Messenger(new DummyMsgService());
    }

    @Test
    public void TestConnectionWithServerForValidAdress() {
        assertThat(messenger.TestConnection("www.wp.pl"), is(0));
    }

    @Test
    public void TestConnectionWithServerForInvalidAdress() {
        assertThat(messenger.TestConnection("www.wp.gov"), is(1));
    }

    @Test
    public void SendCommuniqueForCorrectMessageCorrectServer() {
        assertThat(messenger.SendMsg("Message for", "www.interia.pl"), is(anyOf(equalTo(1), equalTo(0))));
    }

    @Test
    public void SendCommuniqueForWrongMessageCorrectServer() {
        assertThat(messenger.SendMsg("Ab", "www.interia.pl"), is(1));
    }

    @Test
    public void SendCommuniqueForCorrectMessageWrongServer() {
        assertThat(messenger.SendMsg("Message for", "www.interia.gov"), is(1));
    }

    @Test
    public void SendCommuniqueForWrongMessageWrongServer() {
        assertThat(messenger.SendMsg("Av", "www.interia.gov"), is(1));
    }
}

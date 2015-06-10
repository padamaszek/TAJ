
import com.example.mock.app.Messenger;
import com.example.mock.messenger.ConnectionStatus;
import com.example.mock.messenger.IMessageService;
import com.example.mock.messenger.MalformedRecipientException;
import com.example.mock.messenger.SendingStatus;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hunter on 2015-04-15.
 */
public class EasyMockTest extends EasyMockSupport{
    private Messenger messenger;
    private IMessageService mocked;

    @Before
    public void setUp() {
        mocked = createMock(IMessageService.class);
        messenger = new Messenger(mocked);
    }

    @Test
     public void testingTheConnectionSuccess() {
        expect(mocked.checkConnection("www.interia.pl")).andReturn(ConnectionStatus.SUCCESS);
        replay(mocked);
        assertEquals(0,messenger.TestConnection("www.interia.pl"));
    }
    @Test
    public void testingSendingSuccessfully() throws MalformedRecipientException {
        expect(mocked.send("www.interia.pl", "asdfg")).andReturn(SendingStatus.SENT);
        /*replay(mocked);
        assertEquals(0, messenger.SendMsg("www.interia.pl", "asdfg"));
        verify(mocked);*/
    }
}

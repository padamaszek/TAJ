package com.example.mock.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.mock.app.Messenger;
import com.example.mock.messenger.ConnectionStatus;
import com.example.mock.messenger.IMessageService;
import com.example.mock.messenger.MalformedRecipientException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;
/**
 * Created by Hunter on 2015-06-10.
 */
public class MockitoTest {
    private static final String INTERIA_CORRECT = "interia.pl";
    private static final String INTERIA_WRONG = "interia.com.pl";
    private static final String MESSAGE = "asdfg";
    @Spy
    private Messenger messenger;
    private IMessageService mocked;

    @Before
    public void setUp(){
        mocked = mock(IMessageService.class);
        messenger = new Messenger(mocked);
    }

    @Test
    public void ConnectionWithGoodArgument(){
        when(mocked.checkConnection(endsWith(".pl")))
                .thenReturn(ConnectionStatus.SUCCESS);
        assertEquals(0, messenger.TestConnection(INTERIA_CORRECT));
    }

    @Test
    public void ConnectionWithBadParameters(){
        when(mocked.checkConnection(INTERIA_WRONG))
                .thenReturn(ConnectionStatus.FAILURE);
        assertEquals(1, messenger.TestConnection(INTERIA_WRONG));
    }

    @Test
    public void ExceptionWithBadParameter() throws MalformedRecipientException {
        when(mocked.send(INTERIA_CORRECT, "as"))
                .thenThrow(new MalformedRecipientException());
        assertEquals(1, messenger.SendMsg(INTERIA_CORRECT, "as"));
    }

}


import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Rule;
/**
 * Created by Hunter on 2015-04-15.
 */
public class EasyMockTest extends EasyMockSupport{
    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private IMessageService messageService;

    @TestSubject
    private Messenger messenger = new Messenger();

    @After
    public void verifyMock() {
        verifyAll();
    }




}

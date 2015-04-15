import java.util.Random;

/**
 * Created by Hunter on 2015-04-08.
 */
public class DummyMsgService implements IMessageService{

    @Override
    public ConnectionStatus checkConnection(String server) {
        if(server.matches("[A-Za-z]{2,}.pl$")){
            return ConnectionStatus.SUCCESS;
        }
        return ConnectionStatus.FAILURE;
    }

    @Override
    public SendingStatus send(String server, String contents) throws MalformedRecipientException {
        if (server.length() < 4 || contents.length() < 2) {
            throw new MalformedRecipientException();
        }
        Random random = new Random();
        boolean x = random.nextBoolean();
        if(x){
            return  SendingStatus.SENT;
        } else{
            return SendingStatus.SENDING_ERROR;
        }
    }
}

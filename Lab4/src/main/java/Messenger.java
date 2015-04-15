/**
 * Created by Hunter on 2015-04-15.
 */
public class Messenger {
    private IMessageService messageService;

    public Messenger(IMessageService msgService) {
        this.messageService = msgService;
    }

    public Messenger() {

    }
    public int TestConnection(String address) {
        //FAILURE
        if (messageService.checkConnection(address) != ConnectionStatus.SUCCESS)
            return 1;
        //SUCESS
        return 0;
    }

    public int SendMsg(String msg, String address) {
        try {
            SendingStatus ss = messageService.send(address, msg);
            //SEND ERROR
            if (TestConnection(address) != 0 || ss!= SendingStatus.SENT)
                return 1;
        } catch (MalformedRecipientException e) {
            e.printStackTrace();
            return 1;
        }
        //SENT
        return 0;
    }


}
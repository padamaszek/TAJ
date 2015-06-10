/**
 * Created by Hunter on 2015-04-15.
 */
package com.example.mock.app;

import com.example.mock.messenger.ConnectionStatus;
import com.example.mock.messenger.IMessageService;
import com.example.mock.messenger.MalformedRecipientException;
import com.example.mock.messenger.SendingStatus;

public class Messenger {
    private IMessageService messageService;

    public Messenger(IMessageService msgService) {
        this.messageService = msgService;
    }

    public Messenger() {

    }
    public int TestConnection(String address) {
        //FAILURE
        if (messageService.checkConnection(address) != ConnectionStatus.SUCCESS) {
            return 1;
        }else {
            //SUCESS
            return 0;
        }

    }

    public int SendMsg(String msg, String address) {
        try {
            SendingStatus ss = messageService.send(address, msg);
            //SENT
            if (ss == SendingStatus.SENT){
                return 0;
            }
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
package com.example.mock.messenger;

/**
 * Created by Hunter on 2015-04-08.
 */
public interface IMessageService {
    ConnectionStatus checkConnection(String server);

    SendingStatus send(String server, String contents) throws MalformedRecipientException;
}

package com.vm.user.manual.android.event;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hackill
 * @date 2023/5/26
 */
public class MessageHub {

    private final static MessageHub messageHub = new MessageHub();


    private List<MessageReceiver> receiverList;

    private MessageHub() {
        receiverList = new CopyOnWriteArrayList<>();
    }

    public static MessageHub getInstance() {
        return messageHub;
    }


    public void addMessageReceiver(MessageReceiver messageReceiver) {
        if (messageReceiver != null && !receiverList.contains(messageReceiver)) {
            receiverList.add(messageReceiver);
        }
    }

    public void removeMessageReceiver(MessageReceiver messageReceiver) {
        receiverList.remove(messageReceiver);
    }

    public void sendMessage(String content) {
        for (MessageReceiver receiver : receiverList) {
            receiver.onMessageReceive(content);
        }
    }
}

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


    /**
     * 添加监听者，把想要监听消息的人，加到列表中
     *
     * @param messageReceiver
     */
    public void addMessageReceiver(MessageReceiver messageReceiver) {

        if (messageReceiver != null && !receiverList.contains(messageReceiver)) {
            receiverList.add(messageReceiver);
        }
    }

    /**
     * 取消监听
     *
     * @param messageReceiver
     */
    public void removeMessageReceiver(MessageReceiver messageReceiver) {
        //将监听者从list列表中移除
        receiverList.remove(messageReceiver);
    }

    /**
     * 发送消息，发送到这里，
     * 会遍历所有的list中的监听者，通知他们有消息来了
     *
     * @param content
     */
    public void sendMessage(String content) {
        for (int i = 0; i < receiverList.size(); i++) {
            receiverList.get(i).onMessageReceive(content);
        }

    }
}

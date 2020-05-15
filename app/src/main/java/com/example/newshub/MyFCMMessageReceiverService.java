package com.example.newshub;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

public class MyFCMMessageReceiverService extends FirebaseMessagingService {

    public static final String TAG="tag";
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //Receiving notification when app is in foreground
        if(remoteMessage.getNotification()!=null){

            String title=remoteMessage.getNotification().getTitle();
            String body=remoteMessage.getNotification().getBody();
            String clickAction=remoteMessage.getNotification().getClickAction();
            Log.i(TAG,"title:"+title+"  body: "+body+" clickAction: "+clickAction);
            Log.i(TAG,"onMessageReceived is called");

            Notification notification=new NotificationCompat.Builder(this,App.NOTIFICATION)
                    .setSmallIcon(R.drawable.icon_notification)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setColor(Color.YELLOW)
                    .build();

            NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1002,notification);
        }

        if(remoteMessage.getData().size()>0){

            //TODO: on receiving msg when app is in foreground
        }
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.i(TAG, "Refreshed token: " + token);

    }
}

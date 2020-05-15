package com.example.newshub;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String NOTIFICATION="NOTIFICATION_CHANNEL";
    public static final String MESSAGES ="MESSAGE_CHANNEL";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationsChannel();
    }

    private void createNotificationsChannel() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1=new NotificationChannel(
                    NOTIFICATION,
                    "Notification_Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is notification channel");

            NotificationChannel channel2=new NotificationChannel(
                    MESSAGES,
                    "Message_Channel",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is message channel ");

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);
        }
    }
}

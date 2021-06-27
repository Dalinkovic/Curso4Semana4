package com.dossis.curso4semana3.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.dossis.curso4semana3.R;
import com.dossis.curso4semana3.activitys.BaseActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    final static String TAG = "MyFirebaseMessagingService";


    public MyFirebaseMessagingService() {
        //No se activa mas que la primera vez. El token solo se genera al instalar la App.
       /* FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        enviarTokenRegistro(token);
                        // Log and toast
                        //String msg = getString(R.string.msg_token_fmt, token);
                        //  Log.d(TAG, msg);
                        // Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });*/
    }

    @Override
    public void onMessageReceived(@NonNull @NotNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        String body = remoteMessage.getNotification().getBody();
        String title = remoteMessage.getNotification().getTitle();
        Log.d(TAG, "Msg from " + from + " text:" + body);
        launchNotification(title, body);
        //Toast.makeText(this, "Msg from " + from + " text:" + body, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNewToken(@NonNull @NotNull String s) {
        super.onNewToken(s);
        Log.d(TAG, "token:" + s);
        //Toast.makeText(this, "Token:"+s, Toast.LENGTH_SHORT).show();
        // enviarTokenRegistro(s);

    }


    private void launchNotification(String title, String message) {
        try {

            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            String CHANNEL_ID = "principal_Channel";

            Intent intent = new Intent(this, BaseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setSound(sound)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(0, builder.build());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Notification for latest versions";
                String description = "Short description example";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                channel.setDescription(description);
                NotificationManager notificationManager2 = getSystemService(NotificationManager.class);
                notificationManager2.createNotificationChannel(channel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
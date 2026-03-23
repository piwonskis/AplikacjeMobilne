package edu.zsk.a2026_03_23;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        createNotificationChannel();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        button1.setOnClickListener(v ->{
            Intent intent = new Intent(this, MainActivity2.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my_channel_id")
                    .setSmallIcon(R.drawable.openclipart_vectors_linux_2025130)
                    .setContentTitle("Najwyższy priorytet")
                    .setContentText("To powiadomienie najwyższego priorytetu")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            notificationManager.notify(1, builder.build());
        });

        button2.setOnClickListener(v ->{
            Intent intent = new Intent(this, MainActivity3.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my_channel_id")
                    .setSmallIcon(R.drawable.openclipart_vectors_linux_2025130)
                    .setContentTitle("Najmniejszy priorytet")
                    .setContentText("To powiadomienie najniższego priorytetu")
                    .setPriority(NotificationCompat.PRIORITY_MIN)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            notificationManager.notify(1, builder.build());
        });



        }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "my_channel_id",
                    "My Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            channel.setDescription("Opis kanału");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
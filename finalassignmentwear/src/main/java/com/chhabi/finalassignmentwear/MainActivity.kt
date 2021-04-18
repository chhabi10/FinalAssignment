package com.chhabi.finalassignmentwear

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.io.IOException

class MainActivity : WearableActivity() {
private lateinit var btn1:Button
private lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn1.setOnClickListener {
            Datanotifications()
        }









        // Enables Always-on
        setAmbientEnabled()
    }

    private fun Datanotifications () {
        val notificationManager = NotificationManagerCompat.from(this)
        val dataNotification = Datanotifications(this)
        dataNotification.createNotificationChannel()

        val notification = NotificationCompat.Builder(this, dataNotification.CHHANEL1)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("Notification")
                .setContentText("User is added!")
                .setColor(Color.BLACK)
                .build()
        notificationManager.notify(1, notification)


    }



}

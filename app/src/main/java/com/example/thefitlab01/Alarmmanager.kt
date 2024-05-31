package com.example.thefitlab01

import android.Manifest
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.ActivityNavigator


class Alarmmanager : BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(p0: Context?, p1: Intent?) {
        val notificationId = 1 // Unique ID for the notification
        val channelId = "water" // Same as defined in the channel setup
        val title = "thefitlab"
        val contentText = "Drink some more!!"

        val builder = NotificationCompat.Builder(p0!!,"water")
            .setSmallIcon(R.drawable.water)
            .setContentTitle(title)
            .setContentText(contentText)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

// You can add more customization options here

        val notificationManager = NotificationManagerCompat.from(p0)
        notificationManager.notify(notificationId, builder.build())



    }
}
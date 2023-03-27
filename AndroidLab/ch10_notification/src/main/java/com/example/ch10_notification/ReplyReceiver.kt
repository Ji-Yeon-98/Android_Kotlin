package com.example.ch10_notification

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // notification에서 remote input을 유저가 했을 때 입력한 문자열을 키값("key_txt_reply")으로 브로드 캐스터에 전달
        val replyTxt = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_txt_reply")
        Log.d("kkang", "replyTxt:$replyTxt")

        // notification에서 remote input을 유저가 했을 때 실행될 브로드캐스트 리시버 작성 + 유저가 입력한 글을 뽑아봄
        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)

    }
}
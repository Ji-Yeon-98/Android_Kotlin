package com.example.ch10_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //퍼미션 요청 다이얼로그 띄우고 다이얼로그에서 유저가 퍼미션 조정한 값을 받기 위한 callback 준비
        val permissionLauncher = registerForActivityResult(
            // 유저에게 notification 조정 다이얼로그 띄워줌
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            // 유저가 notification 조정한 후에 실행되는 콜백
            if(it.all {permission -> permission.value == true}){ //유저가 퍼미션을 부여했다면
                noti()
            }else{ //퍼미션이 정상적으로 부여되지 않은 상황
                Toast.makeText(this, "permission denied..", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnNotification.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // 33버전 이상이면 퍼미션 체크
                if (ContextCompat.checkSelfPermission(
                        this,
                        "android.permission.POST_NOTIFICATIONS"
                    ) == PackageManager.PERMISSION_GRANTED
                ) { //퍼미션이 정상적으로 부여되어있다면
                    noti()
                } else { //퍼미션이 부여가 안됐다면 퍼미션 런처 구동
                    permissionLauncher.launch(
                        arrayOf("android.permission.POST_NOTIFICATIONS")
                    )
                }
            }else{
                noti()
            }
        }

    }

    fun noti(){
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //오레오 버전 이상이라면
            val channelId = "one-channel"
            val channelName = "My Channel One"
            //채널 생성
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT //중요도 레벨
            ).apply { //채널 부가 설정
                description = "My Channel Description" //설명
                setShowBadge(true) //배치 텍스트

                //알림음 설정
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val autidoAttribution = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes) //채널에다 연결

                enableVibration(true) //진동
            }

            //채널을 notification manager에 등록
            manager.createNotificationChannel(channel)

            //notifcaiton을 만들기 위해 빌더 생서 (오레오 버전부터 channel 개념 도입)
            builder = NotificationCompat.Builder(this, channelId)

        }else{
            builder = NotificationCompat.Builder(this)
        }

        builder.run{
            setSmallIcon(R.drawable.ic_launcher_foreground)
            setWhen(System.currentTimeMillis())
            setContentTitle("추지연")
            setContentText("안녕하세요")
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background))
        }

        val KEY_TEXT_REPLY = "key_text_reply"
        val replyLabel = "답장"
        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()
        }

        val replyIntent = Intent(this, ReplyReceiver::class.java)
        val replyPendingIntent = PendingIntent.getBroadcast(
            this, 30, replyIntent, PendingIntent.FLAG_MUTABLE
        )

        // action 기술로 들어감 (remoteInput 연결), action을 눌렀을 때 입력창이 들어감
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.ic_launcher_background,
                "답장",
                replyPendingIntent
            ).addRemoteInput(remoteInput).build()
        )

        manager.notify(11, builder.build())
    }
}

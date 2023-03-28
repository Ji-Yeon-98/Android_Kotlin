package com.example.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.seekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,  //터치구간탐색
                    progress: Int,      //현재탐색구간
                    fromUser: Boolean   //코드에서 움직이는 것을 구분
                ) {
                    if(fromUser){
                        //사람이 터치로 동작시킬때만 코드 실행
                        textView.text = "$progress"
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}

            })
        }

    }
}
package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.progressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            /// <- 메인 스레드
            // showProgress(true)
            thread(start=true){ /// -> 서브 스레드
                Thread.sleep(3000) //3초간 돌다가 사라짐
                // 화면에 영향을 미치는 코드는 메인스레드로 다시 보내야 한다.
                runOnUiThread {
                    progressLayout.visibility = View.GONE //gone, invisible 안보임, visible 보임
                    //showProgress(false)
                }
            } /// <- 서브 스레드

            /// -> 메인 스레드드
        }

    }

    fun showProgress(show:Boolean){
        binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }

}
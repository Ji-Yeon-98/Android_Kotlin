package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        with(binding){
            checkApple.setOnCheckedChangeListener(checkBoxListener)
            checkBanana.setOnCheckedChangeListener(checkBoxListener)
            checkOrange.setOnCheckedChangeListener(checkBoxListener)
        }
        
//        with(binding){
//            checkApple.setOnCheckedChangeListener { buttonView, isChecked ->
//                if(isChecked) Log.d("체크박스", "사과 선택")
//                else Log.d("체크박스", "사과 해제")
//            }
//            checkBanana.setOnCheckedChangeListener { buttonView, isChecked ->
//                if(isChecked) Log.d("체크박스", "바나나 선택")
//                else Log.d("체크박스", "바나나 해제")
//            }
//            checkOrange.setOnCheckedChangeListener { buttonView, isChecked ->
//                if(isChecked) Log.d("체크박스", "오렌지 선택")
//                else Log.d("체크박스", "오렌지 해제")
//            }


        }
    
        val checkBoxListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            when(buttonView.id){
                R.id.checkApple -> {
                    if(isChecked) Log.d("체크박스", "사과 선택")
                    else Log.d("체크박스", "사과 해제")
                }
                R.id.checkBanana -> {
                    if(isChecked) Log.d("체크박스", "바나나 선택")
                    else Log.d("체크박스", "바나나 해제")
                }
                R.id.checkOrange -> {
                    if(isChecked) Log.d("체크박스", "오렌지 선택")
                    else Log.d("체크박스", "오렌지 해제")
                }
            }
        }
    
}
package com.example.toggleandswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toggleandswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
                textToggle.text = if(isChecked) "On" else "Off"
//                if(isChecked) textToggle.text = "On" else textToggle.text = "Off"
            }

            switchButton.setOnCheckedChangeListener { buttonView, isChecked ->
                textSwitch.text = if(isChecked) "On" else "Off"
            }
        }

    }
}
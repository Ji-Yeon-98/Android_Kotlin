package com.example.scopefunction

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.scopefunction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studyRun()

        // 4. with
        with(binding){
            button.setOnClickListener {  }
            textView.text = "반가워"
       }

    }

    // 스코프 함수
    // run, let, apply, also
    // with

    fun studyRun(){
        val phones  = mutableListOf("010-1234-5678", "010-3456-8978", "010-1234-1234")
        val list = mutableListOf(1,2,3,4,5,6,7,8,9)
        val name = mutableListOf("scott", "Kelly", "Michael")

        // 1. run
        // 코드 축약해서 사용 가능
        phones.run {
            add("010-1234-9784")
            add("000")
        }

        val seoulPeople = SeoulPeople()

        // 실행한 변수와 상관없이 마지막 값을 반환
        val resultRun = seoulPeople.persons.run{
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            size
        }

        Log.d("스코프 함수", "resultRun = ${resultRun}")


        // 2. let
        val resultLet = seoulPeople.persons.let{persons -> //seoulPeople.persons을 persons라고 부름
            persons.add(Person("Scott", "010-1234-5678", 22))
            persons.add(Person("Scott", "010-1234-5678", 22))
            persons.add(Person("Scott", "010-1234-5678", 22))
        }

        Log.d("스코프 함수", "resultLet = ${resultLet}")


        // 3. apply
        // 자기 자신을 되돌려줌, 마지막 코드에 상관없이 스코피 함수에 돌린 변수의 값 그대로 반환
        val resultApply = seoulPeople.persons.apply{
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            11
        }

        Log.d("스코프 함수", "resultApply = ${resultApply}")


        // 4. also
        val resultAlso = seoulPeople.persons.also{persons -> //seoulPeople.persons을 persons라고 부름
            persons.add(Person("Scott", "010-1234-5678", 19))
            persons.add(Person("Scott", "010-1234-5678", 20))
            persons.add(Person("Scott", "010-1234-5678", 21))
            12
        }

        Log.d("스코프 함수", "resultAlso = ${resultAlso}")


    }

}

class SeoulPeople{
    var persons = mutableListOf<Person>()
    init{

    }
}

data class Person(
    var name:String = "",
    var phone:String = "",
    var age:Int = 21
)



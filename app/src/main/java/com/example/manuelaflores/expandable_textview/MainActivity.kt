package com.example.manuelaflores.expandable_textview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.child_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){

        //val list = mutableListOf<ChildViews>()

        fabAdd.setOnClickListener {
            llExpandable.addView(instance())
        }

    }

    fun instance() : View{
        return layoutInflater.inflate(R.layout.child_view,null)
    }

    fun notifyDataSetChange(list: List<ChildViews>){
        removeAllViews()

        for(i in list){
            
        }
    }

    fun removeAllViews(){
        llExpandable.removeAllViews()
    }
}

class ChildViews(val item : String, val value: String)

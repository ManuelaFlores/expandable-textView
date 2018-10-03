package com.example.manuelaflores.expandable_textview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val detailAccessoryGeneralList = mutableListOf<DetailAccessory>()

    val itemsToShow= 3
    var isExpandable= true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        simulateService()
        howManyItemsShow(itemsToShow)

        btnSeeMore.setOnClickListener {
            if( isExpandable) {
                showAllItems(itemsToShow)
            } else {
                isExpandable = false
                removeitemsFrom(itemsToShow)
            }
        }

       /* addItem(DetailAccessory("KITCHEN", "3"))
        addItem(DetailAccessory("ROOM", "2"))
        addItem(DetailAccessory("BEDROOM", "8"))
       addItem(DetailAccessory("GARAGE", "23"))
        addItem(DetailAccessory("LIVING ROOM", "10"))
        addItem(DetailAccessory("ROOM", "2"))
        addItem(DetailAccessory("ROOM", "2"))
        addItem(DetailAccessory("ROOM", "2"))
        addItem(DetailAccessory("ROOM", "2"))*/

        /*val detailAccessoryList = mutableListOf<DetailAccessory>()
        // Retrieve data from web service
        detailAccessoryList.add(DetailAccessory("KITCHEN", "3"))
        detailAccessoryList.add(DetailAccessory("ROOM", "7"))
        detailAccessoryList.add(DetailAccessory("BEDROOM", "8"))
        detailAccessoryList.add(DetailAccessory("GARAGE", "23"))
        detailAccessoryList.add(DetailAccessory("LIVING ROOM", "10"))

        // Add populated list to the View
        addItemList(detailAccessoryList)*/




      /*  fabAdd.setOnClickListener {
            addItem(DetailAccessory("titulo1", "descripcion1"))
            addItem(DetailAccessory("titulo2", "descripcion2"))
        }

        fabRemove.setOnClickListener {
            removeLastItem()
        }*/




    }

    /*private fun addItemList(detailAccessoryList: MutableList<DetailAccessory>) {
        for (detailAccessory in detailAccessoryList) {
            val llChild = LayoutInflater.from(this).inflate(R.layout.child_view, null, false) as LinearLayout
            val tvTitle = llChild.findViewById<TextView>(R.id.tvTitle)
            val tvDescription = llChild.findViewById<TextView>(R.id.tvDescription)
            tvTitle.text = detailAccessory.title
            tvDescription.text = detailAccessory.description
            detailAccessoryGeneralList.add(detailAccessory)
            llExpandable.addView(llChild)
        }
    }*/

    private fun simulateService() {
        detailAccessoryGeneralList.add(DetailAccessory("KITCHEN", "3"))
        detailAccessoryGeneralList.add(DetailAccessory("BATHROOM", "12"))
        detailAccessoryGeneralList.add(DetailAccessory("LIVING ROOM", "14"))
        detailAccessoryGeneralList.add(DetailAccessory("GARAGE", "45"))
        detailAccessoryGeneralList.add(DetailAccessory("ELEVATOR", "78"))
        detailAccessoryGeneralList.add(DetailAccessory("BATHROOM", "8"))
        detailAccessoryGeneralList.add(DetailAccessory("LIVING ROOM", "7"))
        detailAccessoryGeneralList.add(DetailAccessory("BATHROOM", "5"))
        detailAccessoryGeneralList.add(DetailAccessory("KITCHEN", "7"))

        Log.e("longitud", "l ${detailAccessoryGeneralList.size}")
    }

    private fun addItem(detailAccessory: DetailAccessory) {
        val llChild = LayoutInflater.from(this).inflate(R.layout.child_view, null, false) as LinearLayout
        val tvTitle = llChild.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = llChild.findViewById<TextView>(R.id.tvDescription)
        tvTitle.text = detailAccessory.title
        tvDescription.text = detailAccessory.description
        detailAccessoryGeneralList.add(detailAccessory)
        llExpandable.addView(llChild)
    }

    private fun showAllItems(addFrom: Int) {
       // llExpandable.removeAllViews()
        for(i in addFrom until detailAccessoryGeneralList.size) {
            addItem(detailAccessoryGeneralList[i])
            Log.e("longitud", "l ${detailAccessoryGeneralList[i]}")
        }
    }

    private fun howManyItemsShow(items: Int) {
        for(i in 0 until items) {
            addItem(detailAccessoryGeneralList[i])
            Log.e("longitud", "l ${detailAccessoryGeneralList[i]}")
        }
    }

    /**
     * rEMOEATA APPASPD EMSODJF
     * DASKDJFASKJDF SDF
     *
     */
    private fun removeLastItem() {
        val length = detailAccessoryGeneralList.size
        //Data
        detailAccessoryGeneralList.removeAt(length - 1)

        //View
        llExpandable.removeViewAt(length)
    }

    private fun removeitemsFrom(removeFromIndex:Int){
        for (i in detailAccessoryGeneralList.size downTo removeFromIndex step 1) {
            //Data
            detailAccessoryGeneralList.removeAt(i)

            //View
            llExpandable.removeViewAt(i)
        }
    }
}

class DetailAccessory(val title: String, val description: String)

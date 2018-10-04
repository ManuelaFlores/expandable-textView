package com.example.manuelaflores.expandable_textview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val detailAccessoryGeneralListFromService = mutableListOf<DetailAccessory>()
    private val detailAccesoryListToWork = mutableListOf<DetailAccessory>()


    private val itemsToShow= 5
    private var isExpandable= true
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
                btnSeeMore.text = "Ver menos"
                showAllItems(itemsToShow)

            } else {
                isExpandable = false
                btnSeeMore.text= "Ver más"
                removeitemsFrom(itemsToShow)
            }
        }
    }

    /**
     * This function simulates the service: add new values to a list
     * */

    private fun simulateService() {
        detailAccessoryGeneralListFromService.add(DetailAccessory("KITCHEN", "3"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("BATHROOM", "12"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("LIVING ROOM", "14"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("GARAGE", "45"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("ELEVATOR", "78"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("BATHROOM", "8"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("LIVING ROOM", "7"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("BATHROOM", "5"))
        detailAccessoryGeneralListFromService.add(DetailAccessory("KITCHEN", "7"))
    }

    /**
     * This function add an item to a list ; in this case I decided to work with a empty list so
     * this function is in charge to adding an instance of my DetailAccessory class and painting a view for that instance  */

    private fun addItem(detailAccessory: DetailAccessory) {
        val llChild = LayoutInflater.from(this).inflate(R.layout.child_view, null, false) as LinearLayout
        val tvTitle = llChild.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = llChild.findViewById<TextView>(R.id.tvDescription)
        tvTitle.text = detailAccessory.title
        tvDescription.text = detailAccessory.description
        detailAccesoryListToWork.add(detailAccessory)
        llExpandable.addView(llChild)
    }

    /**
     * */

    private fun showAllItems(addFrom: Int) {
        isExpandable = false

        for(i in addFrom until detailAccessoryGeneralListFromService.size) {
            addItem(detailAccessoryGeneralListFromService[i])
        }
    }

    /**
     * */

    private fun howManyItemsShow(items: Int) {
        for(i in 0 until items) {
            addItem(detailAccessoryGeneralListFromService[i])
        }
    }

    /**
     *
     */
    private fun removeLastItem() {
       isExpandable = true

       val length = detailAccesoryListToWork.size

        //Data
        detailAccesoryListToWork.removeAt(length - 1)

        //View
        llExpandable.removeViewAt(length -1)
    }

    private fun removeitemsFrom(removeFromIndex:Int){
        isExpandable = true
        for(i in detailAccesoryListToWork.size-1 downTo removeFromIndex step 1) {
           detailAccesoryListToWork.removeAt( i)
            llExpandable.removeViewAt(i)
        }
    }

}

class DetailAccessory(val title: String, val description: String)

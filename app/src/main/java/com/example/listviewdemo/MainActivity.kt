package com.example.listviewdemo

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listView)
        val randomColor = Color.parseColor("#ffffff")
        listView.setBackgroundColor(randomColor)

        listView.adapter = MyCustomAdapter(this)

    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        private val names = arrayListOf<String>(

            "Bill Gates","Larry Page","Elon Musk","Mark Zuckerberg",
            "Bill Gates","Larry Page","Elon Musk","Mark Zuckerberg",
            "Bill Gates","Larry Page","Elon Musk","Mark Zuckerberg",
            "Bill Gates","Larry Page","Elon Musk","Mark Zuckerberg"

        )

        init {
            mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View

            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(mContext)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                val nTextView = rowMain.name_textView
                val pTextView = rowMain.position_textview
//                val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
//                val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
                val viewHolder = ViewHolder(nTextView,pTextView)
                rowMain.tag = viewHolder

            }else{
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(position)
//            nameTextView.text = names.get(position)

            viewHolder.positionTextView.text = "Row Number: ${position+1}"
//            positionTextView.text = "Row Number: ${position+1}"

            return rowMain

            /*val textView = TextView(mContext)
            textView.text = "Test_rowlistView"
            return textView*/
        }

        override fun getItem(position: Int): Any {
            return ""
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // responsible for how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)

    }

}

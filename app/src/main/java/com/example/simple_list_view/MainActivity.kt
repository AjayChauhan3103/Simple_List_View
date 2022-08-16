package com.example.simple_list_view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.simple_list_view.databinding.ActivityMainBinding
import com.example.simple_list_view.databinding.RowMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val listView = binding.mainListView

        listView.adapter = MyCustomAdaptor(this)

    }
}
private class MyCustomAdaptor(context: Context): BaseAdapter() {

    private val mContext: Context
    private val names = arrayListOf<String>("Ajay Chauhan","Prakash Kunwar","Nayan Boro","Abhishek Pal","Manendra Singh Tripathi","Pappu Singh","Manish Chhetri")

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return names.size

    }

    override fun getItem(position: Int): Any {
        return "Test String"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View? {

        val layoutinflaters = LayoutInflater.from(mContext)
        val rowMain = layoutinflaters.inflate(R.layout.row_main, viewGroup, false)

        val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
        nameTextView.text = names.get(position)

        val positionTextView = rowMain.findViewById<TextView>(R.id.position_Textview)
        positionTextView.text = "Row Number: $position"

        return rowMain

//                val textView = TextView(mContext)
//                textView.text = "HERE is My Rows of the ListView"
//                return textView
    }


}


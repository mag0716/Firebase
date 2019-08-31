package com.github.mag0716.firebase.databasesample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private val dataList = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DataViewHolder(inflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        Log.d("xxx", "onBindViewHolder : $position")
        val data = dataList[position]
        holder.apply {
            titleText.text = data.title
        }
    }

    fun addData(data: List<Data>) {
        val preSize = dataList.size
        dataList.addAll(data)
        notifyItemRangeInserted(preSize, data.size)
    }

    fun addData(data: Data) {
        val preSize = dataList.size
        dataList.add(data)
        notifyItemRangeInserted(preSize, 1)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.title_text)
    }
}
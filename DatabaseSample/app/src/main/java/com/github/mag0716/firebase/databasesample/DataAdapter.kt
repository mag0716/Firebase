package com.github.mag0716.firebase.databasesample

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
        val data = dataList[position]
        holder.apply {
            titleText.text = data.title
        }
    }

    fun getData(index: Int) = dataList[index]

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

    fun addData(index: Int, data: Data) {
        dataList.add(index, data)
        notifyItemRangeInserted(index, 1)
    }

    fun updateData(index: Int, data: Data) {
        dataList[index] = data
        notifyItemChanged(index)
    }

    fun removeData(index: Int) {
        dataList.removeAt(index)
        notifyItemRemoved(index)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.title_text)
    }
}
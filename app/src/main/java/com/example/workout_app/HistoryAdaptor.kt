package com.example.workout_app

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.history_item.view.*
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class HistoryAdaptor(val items:ArrayList<String>,val context: Context):
    RecyclerView.Adapter<HistoryAdaptor.viewHolder>() {

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val llHistoryitem = view.ll_history_item
        val tvItem = view.tvItem
        val tvPosition=view.tvPosition

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate
            (R.layout.history_item,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val date=items.get(position)
        holder.tvPosition.text=(position+1).toString()
        holder.tvItem.text=date

        if(position%2==0){

            holder.llHistoryitem.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        }
        else{

            holder.llHistoryitem.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}



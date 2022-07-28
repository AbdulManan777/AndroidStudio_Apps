package com.example.workout_app

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class ExerciseStatusAdaptor(val items:ArrayList<ExerciseLists>,val context: Context): RecyclerView.Adapter<ExerciseStatusAdaptor.viewHolder>() {

    class viewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvItem=view.tv_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise_status,
            parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val model:ExerciseLists=items[position]
        holder.tvItem.text=model.getID().toString()

        if(model.getIsSelected()==true){

            holder.tvItem.background=ContextCompat.getDrawable(context,
                R.drawable.item_circular_thin_accent_border)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }

        else if(model.getIsCompleted()){

            holder.tvItem.background=ContextCompat.getDrawable(context,
                R.drawable.item_cicular_color_accent_background)
            holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))


        }

        else{


            holder.tvItem.background=ContextCompat.getDrawable(context,
                R.drawable.item_cicular_color_gray_background)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
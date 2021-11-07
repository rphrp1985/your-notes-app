package com.prianshuprasad.yournotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recyclerviewadapter(private val context : Context,private  val listener:Irv): RecyclerView.Adapter<noteviewholder>() {

  val allnotess= ArrayList<notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteviewholder {

       val viewholder= noteviewholder(LayoutInflater.from(context).inflate(R.layout.raw_data, parent ,false))
  viewholder.delbuttom.setOnClickListener{
      listener.onitemclicked(allnotess[viewholder.adapterPosition])
  }



   return  viewholder
           }

    override fun onBindViewHolder(holder: noteviewholder, position: Int) {
        val currennote= allnotess[position]

     holder.text.text= currennote.text
    //        holde= currennote.text
    }

    override fun getItemCount(): Int {
        return  allnotess.size
    }

    fun update(list: List<notes>){
        allnotess.clear()
        allnotess.addAll(list)
        notifyDataSetChanged()


    }



}


 class noteviewholder(item: View):RecyclerView.ViewHolder(item){

    val text= item.findViewById<TextView>(R.id.notetext)
    val delbuttom= item.findViewById<ImageView>(R.id.deletebutton)

}
interface Irv{
    fun onitemclicked(note:notes)
    {

    }


}
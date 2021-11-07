package com.prianshuprasad.yournotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Irv {

    lateinit var viwmodel: viewholder
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager= LinearLayoutManager(this)
        val adapter= recyclerviewadapter(this,this)

        recyclerview.adapter=adapter


  viwmodel= ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(viewholder::class.java)
        viwmodel.allnotes.observe(this, Observer{
         it?.let { adapter.update(it) }
        })










    }

    override fun onitemclicked(note: notes) {
  viwmodel.deletenote(note)
        Toast.makeText(this, "Deleted",Toast.LENGTH_LONG).show()
    }


    fun onsavebutton(view: android.view.View) {

        val newnote:String= newnotes.text.toString()
        if(!newnote.isEmpty())
        viwmodel.insertnote(notes(newnote))
      else
      Toast.makeText(this,"Empty note can not be saved",Toast.LENGTH_LONG).show()

    }


}
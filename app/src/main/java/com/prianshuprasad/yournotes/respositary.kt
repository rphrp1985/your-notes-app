package com.prianshuprasad.yournotes

import androidx.lifecycle.LiveData

class respositary(private  val daonotes: notedao) {

    var allnotes:LiveData<List<notes>> = daonotes.getAll()
    suspend fun insert(note:notes){
        daonotes.insert(note);
//      daonotes.getAll()
    }
    suspend fun delete(note: notes){
        daonotes.delete(note)
    }




}
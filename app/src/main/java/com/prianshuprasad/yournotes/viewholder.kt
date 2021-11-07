package com.prianshuprasad.yournotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewholder(apllication: Application): AndroidViewModel(apllication) {

    val repo:respositary
    var allnotes: LiveData<List<notes>>

    init {
        val dao= database.getDatabase(apllication).notesDao()
         repo= respositary(dao)
        allnotes= repo.allnotes

    }

    fun deletenote(note:notes)= viewModelScope.launch(Dispatchers.IO) {


        repo.delete(note)
    }

    fun insertnote(note:notes)=viewModelScope.launch {
        repo.insert(note)
    }


}
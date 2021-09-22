package tr.com.mekhti.ricknmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tr.com.mekhti.ricknmorty.model.Character
import tr.com.mekhti.ricknmorty.network.Repository
import tr.com.mekhti.ricknmorty.network.responses.GetCharactersResult

class MainViewModel : ViewModel() {

    private val repository  = Repository()
    private val _characters = MutableLiveData<GetCharactersResult?>()
    val characters : LiveData<GetCharactersResult?> = _characters

    fun getCharacters(){
        viewModelScope.launch {
            val response = repository.getCharacters()

            _characters.postValue(response)
        }
    }

}
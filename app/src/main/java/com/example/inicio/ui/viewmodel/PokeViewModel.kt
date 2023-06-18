package com.example.inicio.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inicio.data.domain.GetPokemons
import com.example.inicio.data.domain.model.PokeItem
import kotlinx.coroutines.launch

enum class ApiStatus {LOADING, ERROR, DONE}

class PokeViewModel : ViewModel() {

    private var _pokemonList = MutableLiveData<List<PokeItem>>()
    val pokemonList: LiveData<List<PokeItem>>
            get() = _pokemonList

    /*Una propiedad privada _pokemonList de tipo MutableLiveData<List<PokeItem>> que almacena la lista de Pokémon.
    La lista se expone a través de la propiedad pública pokemonList como una instancia de LiveData<List<PokeItem>>.
    Esto permite que las actividades o fragmentos observen los cambios en la lista de Pokémon y reaccionen en consecuencia.*/

    private var _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
            get() = _status
/*Una propiedad privada _status de tipo MutableLiveData<ApiStatus> que representa el estado de la solicitud de obtención de
la lista de Pokémon. El estado se expone a través de la propiedad pública status como una instancia de LiveData<ApiStatus>.
Los posibles valores de ApiStatus son LOADING (cargando), ERROR (error) y DONE (completado).*/
    init {
        getAllPokemons()
    }
/*El método init se llama cuando se crea una instancia de PokeViewModel. En este método, se llama al método getAllPokemons()
para obtener la lista de Pokémon.*/
    fun getAllPokemons() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                _pokemonList.value = GetPokemons().listAll()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                Log.d("tag", "${e.message}")
                _pokemonList.value = listOf()
            }
        }
    }
    /*El método público getAllPokemons() se encarga de realizar la solicitud para obtener la lista de Pokémon. Dentro de un contexto
    de viewModelScope.launch, se realiza la llamada al método GetPokemons().listAll() para obtener la lista de Pokémon.
    Se manejan las posibles excepciones y se actualiza el valor de _pokemonList y _status en consecuencia.*/


}
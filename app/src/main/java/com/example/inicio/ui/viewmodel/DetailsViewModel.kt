package com.example.inicio.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inicio.data.domain.GetDetails
import com.example.inicio.data.domain.model.PokeItemDetails
import com.example.inicio.ui.view.DetailFragment
import kotlinx.coroutines.launch

enum class ApiStatusDetail {LOADING, ERROR, DONE}

class DetailsViewModel(): ViewModel() {
/*La clase DetailsViewModel extiende la clase ViewModel de Android Jetpack y se encarga de manejar los datos y la lógica
relacionada con la obtención de detalles de un Pokémon específico.*/

    private var _pokeDetails = MutableLiveData<PokeItemDetails>()
    val pokeDetails: LiveData<PokeItemDetails> get() = _pokeDetails

    /*Una propiedad privada _pokeDetails de tipo MutableLiveData<PokeItemDetails> que almacena los detalles de un Pokémon.
    Los detalles se exponen a través de la propiedad pública pokeDetails como una instancia de LiveData<PokeItemDetails>.
    Esto permite que las actividades o fragmentos observen los cambios en los detalles del Pokémon y reaccionen en consecuencia.*/

    private var _status = MutableLiveData<ApiStatusDetail>()
    val status: LiveData<ApiStatusDetail>
        get() = _status

    /*Una propiedad privada _status de tipo MutableLiveData<ApiStatusDetail> que representa el estado de la solicitud de
    obtención de detalles de Pokémon. El estado se expone a través de la propiedad pública status como una instancia de
    LiveData<ApiStatusDetail>. Los posibles valores de ApiStatusDetail son LOADING (cargando), ERROR (error) y
    DONE (completado).*/
    init {
        getPokemonDetails(DetailFragment.idP)
    } /*El método init se llama cuando se crea una instancia de DetailsViewModel. En este método, se obtienen los detalles
    del Pokémon utilizando el método getPokemonDetails().*/

    private fun getPokemonDetails(id: Int) {
        _status.value = ApiStatusDetail.LOADING
        viewModelScope.launch {
            try {
                _pokeDetails.value = GetDetails().fromPokemon(id)
                _status.value = ApiStatusDetail.DONE
            } catch (e: Exception) {
                _status.value = ApiStatusDetail.ERROR
                Log.d("tag", "${e.message}")
            }
        }
    }
    /*El método privado getPokemonDetails() se encarga de realizar la solicitud para obtener los detalles de un Pokémon
    específico. Dentro de un contexto de viewModelScope.launch, se realiza la llamada al método GetDetails().fromPokemon(id)
    para obtener los detalles del Pokémon utilizando el ID proporcionado. Se manejan las posibles excepciones y se
    actualiza el valor de _pokeDetails y _status en consecuencia.*/

}
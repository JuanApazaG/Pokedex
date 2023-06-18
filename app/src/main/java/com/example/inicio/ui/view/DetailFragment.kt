@file:Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")

package com.example.inicio.ui.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.inicio.R
import com.example.inicio.databinding.FragmentDetailBinding
import com.example.inicio.ui.viewmodel.ApiStatusDetail
import com.example.inicio.ui.viewmodel.DetailsViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
/*DetailFragment, que es un fragmento utilizado para mostrar los detalles de un Pokémon en la interfaz de usuario.*/

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    /*El fragmento DetailFragment infla el diseño del fragmento utilizando el archivo de diseño FragmentDetailBinding*/

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        /*método onCreate para obtener el ID del Pokémon desde los argumentos del fragmento.
        Esto se utiliza para cargar los detalles del Pokémon correspondiente utilizando el DetailsViewModel.*/

        super.onCreate(savedInstanceState)
        arguments?.let {
            idP = it.getInt("id")
        }
    }

    override fun onCreateView(

        /*Utiliza el método onViewCreated para observar el estado de la API y los detalles del Pokémon mediante el uso del
        DetailsViewModel*/
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        /*Codigo implementado para arreglar del valor nulo para poder subirlo a github */
        val binding = _binding ?: return null
        /*----------------------------------------------------*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStatus()
        observe()
    }

    private fun observe() {
        /*La función observe se utiliza para observar los cambios en los detalles del Pokémon y actualizar los elementos de la
        interfaz de usuario correspondientes, como los tipos, la imagen, el título, las estadísticas, el peso y la altura.*/
        viewModel.pokeDetails.observe(viewLifecycleOwner) { pokemon ->

            if (pokemon.types.size > 1) {
                binding.tvType1.text = pokemon.types[0]
                binding.tvType1
                binding.tvType2.text = pokemon.types[1]
                binding.tvType2.visibility = View.VISIBLE
            } else {
                binding.tvType1.text = pokemon.types[0]
                binding.tvType2.visibility = View.GONE
            }

            Picasso.get().load(pokemon.img)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(binding.image)

            binding.collapsingToolbar.title = pokemon.name
            binding.tvHp.text = pokemon.hp.toString()
            binding.speed.text = pokemon.speed.toString()
            binding.attack.text = pokemon.attack.toString()
            binding.defense.text = pokemon.defense.toString()
            binding.specialAttack.text = pokemon.specialAttack.toString()
            binding.specialDefense.text = pokemon.specialDefense.toString()
            binding.height.text = getString(R.string.metro, pokemon.height.toString())
            binding.weight.text = getString(R.string.kilo, pokemon.weight.toString())
        }
    }

    private fun observeStatus() {
        /* La función observeStatus se encarga de cambiar la visibilidad de los elementos de la interfaz de
        usuario en función del estado de la API, como la carga en curso, la carga completada o un error.*/
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when (status) {
                ApiStatusDetail.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.appBar.visibility = View.GONE
                    binding.nestedScrollView.visibility = View.GONE
                    binding.statusOffline.visibility = View.GONE
                }
                ApiStatusDetail.DONE -> {
                    binding.progressBar.visibility = View.GONE
                    binding.appBar.visibility = View.VISIBLE
                    binding.nestedScrollView.visibility = View.VISIBLE
                    binding.statusOffline.visibility = View.GONE
                }
                ApiStatusDetail.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.appBar.visibility = View.GONE
                    binding.nestedScrollView.visibility = View.GONE
                    binding.statusOffline.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        var idP = 0
    }
}
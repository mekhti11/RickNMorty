package tr.com.mekhti.ricknmorty.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import tr.com.mekhti.ricknmorty.R
import tr.com.mekhti.ricknmorty.databinding.FragmentCharacterDetailBinding
import tr.com.mekhti.ricknmorty.databinding.FragmentCharactersBinding
import tr.com.mekhti.ricknmorty.model.RNMCharacter
import tr.com.mekhti.ricknmorty.view.MainActivity
import tr.com.mekhti.ricknmorty.view.adapters.CharactersAdapter
import tr.com.mekhti.ricknmorty.viewmodel.MainViewModel


class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CharactersAdapter
    private var characters : ArrayList<RNMCharacter> = arrayListOf()
    private lateinit var navController : NavController


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)

        viewModel = (activity as MainActivity).getViewModel()


        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        setUpRV()
        observeCharacters()


        return binding.root
    }

    private fun setUpRV() {

        adapter = CharactersAdapter(arrayListOf(),onSelect = {
            val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(it!!)
            navController.navigate(action)
        })

        binding.rvCharacters.layoutManager = LinearLayoutManager(context)
        binding.rvCharacters.adapter = adapter
    }

    private fun observeCharacters() {
        viewModel.characters.observe(viewLifecycleOwner, {
//            characters = it!!
            adapter.setData(it!!)
        })
    }

}
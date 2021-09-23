package tr.com.mekhti.ricknmorty.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import tr.com.mekhti.ricknmorty.databinding.FragmentCharacterDetailBinding
import tr.com.mekhti.ricknmorty.model.RNMCharacter
import tr.com.mekhti.ricknmorty.view.adapters.EpisodesAdapter


class CharacterDetailFragment : Fragment() {

    val args : CharacterDetailFragmentArgs by navArgs()
    private var _binding: FragmentCharacterDetailBinding? = null
    private lateinit var character : RNMCharacter
    private lateinit var  adapter : EpisodesAdapter



    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        character = args.character

        binding.character = character

        adapter = EpisodesAdapter(character.episodes)


        binding.clDropdown.setOnClickListener {
            binding.rvEpisodes.visibility = VISIBLE
            binding.rvEpisodes.layoutManager = LinearLayoutManager(context)
            binding.rvEpisodes.adapter = adapter
        }

        binding.imgClose.setOnClickListener { activity?.onBackPressed() }

        return binding.root
    }

}
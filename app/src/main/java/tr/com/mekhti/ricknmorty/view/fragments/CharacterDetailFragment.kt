package tr.com.mekhti.ricknmorty.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import tr.com.mekhti.ricknmorty.databinding.FragmentCharacterDetailBinding


class CharacterDetailFragment : Fragment() {

    val args : CharacterDetailFragmentArgs by navArgs()
    private var _binding: FragmentCharacterDetailBinding? = null



    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        val  character = args.character



        return binding.root
    }

}
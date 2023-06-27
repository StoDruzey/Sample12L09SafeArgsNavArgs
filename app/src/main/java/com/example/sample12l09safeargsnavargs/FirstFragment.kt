package com.example.sample12l09safeargsnavargs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sample12l09safeargsnavargs.databinding.FragmentFirstBinding
import kotlin.random.Random

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFirstBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
//            arguments = bundleOf(SecondFragment.KEY_INFO to Random.nextInt().toString())
            findNavController()
                .navigate(R.id.to_fragment_second,
                    bundleOf(SecondFragment.KEY_INFO to Random.nextInt().toString()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
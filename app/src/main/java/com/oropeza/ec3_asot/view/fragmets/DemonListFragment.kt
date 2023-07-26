package com.oropeza.ec3_asot.view.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oropeza.ec3_asot.R
import com.oropeza.ec3_asot.RVDemonListAdapter
import com.oropeza.ec3_asot.databinding.FragmentDemonListBinding

class DemonListFragment : Fragment() {

    private lateinit var binding: FragmentDemonListBinding
    private lateinit var viewModel: DemonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(DemonListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDemonListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVDemonListAdapter(listOf())
        binding.rvDemonList.adapter = adapter
        binding.rvDemonList.layoutManager = GridLayoutManager(requireContext(),2, RecyclerView.VERTICAL,false)
        viewModel.demonList.observe(requireActivity()) {
            adapter.demons = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getDemonFromService()
    }
}
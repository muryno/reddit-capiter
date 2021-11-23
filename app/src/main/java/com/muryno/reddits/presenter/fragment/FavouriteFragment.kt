package com.muryno.reddits.presenter.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.muryno.reddits.databinding.FragmentFavouriteBinding
import com.muryno.reddits.presenter.activity.MainActivity
import com.muryno.reddits.presenter.adapter.FavouritePostAdapter
import com.muryno.reddits.presenter.utils.SwipeGesture
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModel
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModelFactory
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModel
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModelFactory
import javax.inject.Inject


class FavouriteFragment : Fragment() {
    @Inject
    lateinit var favouriteFragmentRedditViewModelFactory : FavouriteFragmentRedditViewModelFactory

    @Inject
    lateinit var adapter: FavouritePostAdapter



    private val favouriteFragmentRedditViewModel: FavouriteFragmentRedditViewModel by lazy {
        ViewModelProvider(this,favouriteFragmentRedditViewModelFactory)[FavouriteFragmentRedditViewModel::class.java]
    }

    lateinit var binding: FragmentFavouriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FavouriteFragment
            viewModel = favouriteFragmentRedditViewModel
            favouriteRecyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favouriteFragmentRedditViewModel.getRedditFavouritePost()

        favouriteFragmentRedditViewModel.favouriteResult.observe(viewLifecycleOwner,{
            if(it!= null){
                adapter.differ.submitList(it)
            }
        })


        val swiper = object : SwipeGesture(requireContext()){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction){
                    ItemTouchHelper.LEFT ->{
                        favouriteFragmentRedditViewModel.deleteAllFavourite()
                    }
                }
            }
        }

        val itemHelper = ItemTouchHelper(swiper)
        itemHelper.attachToRecyclerView(binding.favouriteRecyclerView)

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(
            this
        )
    }

}
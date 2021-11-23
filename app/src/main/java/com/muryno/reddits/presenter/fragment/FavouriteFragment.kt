package com.muryno.reddits.presenter.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.muryno.reddits.R
import com.muryno.reddits.databinding.FragmentFavouriteBinding
import com.muryno.reddits.presenter.activity.DetailsActivity
import com.muryno.reddits.presenter.activity.MainActivity
import com.muryno.reddits.presenter.adapter.FavouritePostAdapter
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModel
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModelFactory
import javax.inject.Inject


class FavouriteFragment : Fragment() {
    @Inject
    lateinit var favouriteFragmentRedditViewModelFactory : FavouriteFragmentRedditViewModelFactory


    private lateinit var adapter: FavouritePostAdapter


    private val favouriteFragmentRedditViewModel: FavouriteFragmentRedditViewModel by lazy {
        ViewModelProvider(this,favouriteFragmentRedditViewModelFactory)[FavouriteFragmentRedditViewModel::class.java]
    }


    lateinit var binding: FragmentFavouriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        adapter = FavouritePostAdapter {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(context?.getString(R.string.data), it)
            startActivity(intent)
        }

        binding = FragmentFavouriteBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FavouriteFragment
            viewModel = favouriteFragmentRedditViewModel
            favouriteRecyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            favouriteToolbar.inflateMenu(R.menu.favourite_menu)
            favouriteToolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.delete_post -> {
                        favouriteFragmentRedditViewModel.deleteAllFavourite()
                        loadFavoritePost()
                        true
                    }
                    else -> {
                        super.onOptionsItemSelected(it)
                    }
                }
            }
        }


    }

  private fun loadFavoritePost(){
        favouriteFragmentRedditViewModel.getRedditFavouritePost()
        favouriteFragmentRedditViewModel.favouriteResult.observe(viewLifecycleOwner,{
                adapter.differ.submitList(it)

        })
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(
            this
        )
    }

    override fun onResume() {
        loadFavoritePost()
        super.onResume()

    }


}
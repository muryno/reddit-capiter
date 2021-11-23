package com.muryno.reddits.presenter.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.muryno.reddits.R
import com.muryno.reddits.databinding.FragmentHomeBinding
import com.muryno.reddits.presenter.activity.DetailsActivity
import com.muryno.reddits.presenter.activity.MainActivity
import com.muryno.reddits.presenter.adapter.RedditAdapter
import com.muryno.reddits.presenter.adapter.RedditLoadingAdapter
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModel
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class HomeFragment : Fragment() {
    private val mDisposable = CompositeDisposable()
    @Inject
    lateinit var viewModelFactoryHomeFragment : HomeFragmentRedditViewModelFactory
    private lateinit var mAdapter: RedditAdapter

    private val homeFragmentRedditViewModel: HomeFragmentRedditViewModel by lazy {
        ViewModelProvider(this,viewModelFactoryHomeFragment)[HomeFragmentRedditViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(
            this
        )

    }

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HomeFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        mDisposable.add(homeFragmentRedditViewModel.getRedditPost(null).subscribe{
            mAdapter.submitData( lifecycle,it)
        }
        )
    }

    private fun setupViews() {
        mAdapter = RedditAdapter{
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra(resources.getString(R.string.data), it)
            startActivity(intent)
        }
        binding.apply {

            rvPosts.adapter = mAdapter
            rvPosts.adapter = mAdapter.withLoadStateHeaderAndFooter(
                header = RedditLoadingAdapter { mAdapter.retry() },
                footer = RedditLoadingAdapter { mAdapter.retry() }

            )


            redditSearch.setOnQueryTextListener(  object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    mDisposable.add(homeFragmentRedditViewModel.getRedditPost(query).subscribeBy (
                        onNext = {
                            mAdapter.submitData( lifecycle,it)
                        },
                    )
                    )
                    return false
                }
            })
        }


    }

   private fun showProgressBar(boolean: Boolean){
        if(!boolean)
            binding.redditProgressBar.visibility = View.GONE
        else
            binding.redditProgressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
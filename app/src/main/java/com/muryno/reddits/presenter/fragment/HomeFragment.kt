package com.muryno.reddits.presenter.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.filter
import androidx.paging.flatMap
import androidx.paging.map
import com.muryno.reddits.databinding.FragmentHomeBinding
import com.muryno.reddits.presenter.activity.DetailsActivity
import com.muryno.reddits.presenter.activity.MainActivity
import com.muryno.reddits.presenter.adapter.RedditAdapter
import com.muryno.reddits.presenter.adapter.RedditLoadingAdapter
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModel
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.muryno.reddits.R
import com.muryno.reddits.presenter.utils.SwipeGesture
import io.reactivex.rxkotlin.subscribeBy
import okhttp3.internal.wait


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
        showProgressBar(true)
        mDisposable.add(homeFragmentRedditViewModel.getRedditPost().subscribeBy (
            onNext = {
                showProgressBar(it==null)
                mAdapter.submitData( lifecycle,it)

            },
            onError = {showProgressBar(false)}
            )
        )

    }

    private fun setupViews() {
        mAdapter = RedditAdapter{
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra(resources.getString(R.string.data), it)
            startActivity(intent)
        }
        binding.rvPosts.adapter = mAdapter
        binding.rvPosts.adapter = mAdapter.withLoadStateHeaderAndFooter(
            header = RedditLoadingAdapter { mAdapter.retry() },
            footer = RedditLoadingAdapter { mAdapter.retry() }
        )
    }


   private fun showProgressBar(isEmpty: Boolean){
        if(isEmpty)
            binding.redditProgressBar.visibility = View.VISIBLE
        else
            binding.redditProgressBar.visibility = View.GONE
    }




    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }
}
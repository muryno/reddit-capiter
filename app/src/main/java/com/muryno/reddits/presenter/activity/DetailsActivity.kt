package com.muryno.reddits.presenter.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.reddits.App
import com.muryno.reddits.R
import com.muryno.reddits.databinding.FragmentDetailsBinding
import com.muryno.reddits.presenter.viewmodel.DetailsViewModel
import com.muryno.reddits.presenter.viewmodel.DetailsViewModelFactory
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModel
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModelFactory
import javax.inject.Inject


class DetailsActivity : AppCompatActivity() {
    var binding: FragmentDetailsBinding? = null
    private var redditPostEntity : RedditPostEntity?= null

    @Inject
    lateinit var detailsViewModelFactory : DetailsViewModelFactory

    private val detailsViewModel: DetailsViewModel by lazy {
        ViewModelProvider(this,detailsViewModelFactory)[DetailsViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_details)

        (applicationContext as App).appComponent.inject(this)

        redditPostEntity = intent.getParcelableExtra(resources.getString(R.string.data))
        if (redditPostEntity != null) {
            binding?.reddits = redditPostEntity
        }
        binding?.lifecycleOwner = this
        binding?.viewModel = detailsViewModel
        // my_child_toolbar is defined in the layout file
        setSupportActionBar(findViewById(R.id.details_toolbar))
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding?.apply {
            deleteButton.setOnClickListener {
                if(redditPostEntity!= null ) {
                    detailsViewModel.deleteAllFavourite(redditPostEntity?.id?:"")
                    finish()
                }
            }
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}



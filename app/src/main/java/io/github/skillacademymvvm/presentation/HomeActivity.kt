package io.github.skillacademymvvm.presentation

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.support.DaggerAppCompatActivity
import io.github.skillacademymvvm.R
import io.github.skillacademymvvm.data.ResultResponse
import io.github.skillacademymvvm.databinding.ActivityMainBinding
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeViewModelCallback {

    @Inject
    lateinit var viewModel: HomeViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main)
            .apply { viewModel = this@HomeActivity.viewModel }
            .also { viewModel.discoverMovie() }
    }

    override fun onDestroy() {
        viewModel.onDetach()
        super.onDestroy()
    }

    override fun onSuccess(resultResponse: List<ResultResponse>) {
        binding.rvHome.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        binding.rvHome.adapter = HomeAdapter(resultResponse)
    }

    override fun onError(error: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
    }
}
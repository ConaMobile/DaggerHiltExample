package com.conamobile.daggerhiltexample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.conamobile.daggerhiltexample.utils.GithubResource
import com.conamobile.daggerhiltexample.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GithubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        lifecycleScope.launch(Dispatchers.Main) {
//            withContext(Dispatchers.Main) {
            viewModel.getUsers().collect {
                when (it) {
                    is GithubResource.Error -> {
                        Log.d("@@@", it.message)
                    }
                    is GithubResource.Loading -> {}
                    is GithubResource.Success -> {
                        Log.d("@@@", "List: ${it.list}")
                    }
                }
            }
//            }
        }
    }
}
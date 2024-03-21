package com.cristian.castellanos.exampledriveui.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.Toast
import com.cristian.castellanos.exampledriveui.R
import com.cristian.castellanos.exampledriveui.Status
import com.cristian.castellanos.exampledriveui.data.repository.PageRepositoryImpl
import com.cristian.castellanos.exampledriveui.databinding.ActivityMainBinding
import com.cristian.castellanos.exampledriveui.di.ApiService
import com.cristian.castellanos.exampledriveui.di.RetrofitClient
import com.cristian.castellanos.exampledriveui.domain.model.PageUI
import com.cristian.castellanos.exampledriveui.domain.usecase.PageUseCaseImpl
import com.cristian.castellanos.exampledriveui.presentation.components.commons.createViewGroup
import com.cristian.castellanos.exampledriveui.presentation.viewmodel.PageViewModel
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pageViewModel = PageViewModel(PageUseCaseImpl(PageRepositoryImpl(RetrofitClient.apiService, Dispatchers.IO)))
        fetchPage()
        observerData()


    }

    private fun observerData() {
        pageViewModel.status.observe(this) {
            when (it) {
                is Status.Error -> {
                    Toast.makeText(this@MainActivity, "${it.message}Error", Toast.LENGTH_SHORT).show()
                }
                is Status.Loading -> {
                    Toast.makeText(this@MainActivity, "Cargando", Toast.LENGTH_SHORT).show()
                }
                is Status.Success<*> -> {
                    val container = this@MainActivity.createViewGroup()

                    (it.data as PageUI).data.apply {
                        /*header.mapToView(this@MainActivity)?.let { view ->
                            container.addView(view)
                        }*/
                        body.map { component ->
                            component.mapToView(this@MainActivity)?.let { view ->
                                container.addView(view)
                            }
                        }
                        /*footer.mapToView(this@MainActivity)?.let { view ->
                            container.addView(view)
                        }*/
                        binding.scrollContainer.addView(container)
                    }

                }
            }
        }
    }

    private fun fetchPage() {
        pageViewModel.getPages()
    }
}
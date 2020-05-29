package com.aliakberaakash.thirtydayschallenge.core.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<ViewModel: BaseViewModel, Binding: ViewDataBinding> : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var binding: Binding

    abstract fun getLayoutId(): Int

    abstract fun setVariables(binding: Binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        setVariables(binding)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    private fun getViewModelClass(): Class<ViewModel> {
        val type =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<ViewModel>
    }

}
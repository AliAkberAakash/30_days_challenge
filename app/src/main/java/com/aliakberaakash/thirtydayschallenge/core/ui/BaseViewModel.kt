package com.aliakberaakash.thirtydayschallenge.core.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.orhanobut.logger.Logger


class BaseViewModel(private val myApplication: Application) : AndroidViewModel(myApplication), IViewModel {
    override fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?) {
        Logger.d("${event?.name}")
    }


    override fun onCreate(){

    }

    override fun onDestroy(){

    }

    override fun onStart(){

    }

    override fun onStop(){

    }

    override fun onResume(){

    }

    override fun onPause(){

    }

}
package com.example.databindingmvvmdemo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.databindingmvvmdemo.R
import com.example.databindingmvvmdemo.databinding.ActivityMainBinding
import com.example.databindingmvvmdemo.viewmodels.LoginViewModel

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // here we connecting xml layout and koting with using binding
      val activityMainBinding: ActivityMainBinding =
          DataBindingUtil.setContentView(this, R.layout.activity_main)
          activityMainBinding.viewModel = LoginViewModel()
          activityMainBinding.executePendingBindings()
    }

    companion object
    {
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun runMe(view: View, message: String?)
        {
            if (message != null)
            {
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.databindingmvvmdemo.viewmodels

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.databindingmvvmdemo.BR
import com.example.databindingmvvmdemo.model.User
import com.example.databindingmvvmdemo.views.ProfilePage
import com.example.databindingmvvmdemo.views.Shopping

class LoginViewModel : BaseObservable()
{

    private var user: User = User("", "")
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @get:Bindable
    var toastMessage: String? = null
        set(value)
        {
            field = value
            notifyPropertyChanged(BR.toastMessage)
        }

    fun setUserEmail(email: String)
    {
        user.email = email
        notifyPropertyChanged(BR.userEmail)
    }

    @get:Bindable
    val userEmail: String
        get() = user.email

    @get:Bindable
    val userPassword: String
        get() = user.password

    fun setUserPassword(password: String)
    {
        user.password = password
        notifyPropertyChanged(BR.userPassword)
    }

    fun onLoginClicked(context: Context)
    {
        if (isInputDataValid())
        {
            toastMessage = successMessage

            val intent = Intent(context, Shopping::class.java)
            context.startActivity(intent)
        }
        else
        {
            toastMessage = errorMessage
        }
    }

    private fun isInputDataValid(): Boolean
    {
        return !TextUtils.isEmpty(userEmail) &&
                Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() &&
                userPassword.length > 6
    }
}

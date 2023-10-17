package com.example.android.marsphotos.ui.auth

import  android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.marsphotos.R
import com.example.android.marsphotos.data.db.entities.User
import com.example.android.marsphotos.databinding.ActivityLoginBinding
import com.example.android.marsphotos.ui.main.MainActivity
import com.example.android.marsphotos.util.LoadingCustom
import com.example.android.marsphotos.util.ToastCustom


class LoginActivity : AppCompatActivity(), AuthListener{
    lateinit var viewModel : AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar!!.hide()

        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
         viewModel =  ViewModelProvider(this).get(AuthViewModel::class.java)
         binding.viewmodelLogin = viewModel

         viewModel.authListener = this


     }

    override fun onStarted() {

        LoadingCustom.initialize(this)
        LoadingCustom.startLoadingDialog()


    }

    override fun onSuccess(user:User, session:String) {
        LoadingCustom.dismissDialog();
        val sharedPreference =  getSharedPreferences("User_Curent", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("session",session)
        editor.commit()
        ToastCustom.makeText(
            this,
            user.username_mytv,
            Toast.LENGTH_LONG,
            ToastCustom.WARNING,
            true
        ).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    override fun onFailure(message: String) {

        LoadingCustom.dismissDialog();

        ToastCustom.makeText(
            this,
            message,
            Toast.LENGTH_LONG,
            ToastCustom.WARNING,
            true
        ).show()
    }
}
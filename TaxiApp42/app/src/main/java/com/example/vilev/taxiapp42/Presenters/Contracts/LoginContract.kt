package com.example.vilev.taxiapp42.Presenters.Contracts

/**
 * Created by vilev on 12.04.2017.
 */
interface LoginContract {
    interface Presenter {
        fun onLogin(login:      String,
                    password:   String)
    }
    interface View {
        fun onLoginSuccess(login: String)
        fun onLoginFailure(errorMessage: String)
    }
}
package com.example.vilev.taxiapp42.Presenters.Contracts

/**
 * Created by vilev on 12.04.2017.
 */
interface RegistrationContract {
    interface Presenter {
        fun onRegistration(login:       String,
                           password:    String,
                           surname:     String,
                           name:        String,
                           faculty:     String,
                           avatar:      String)
    }
    interface View {
        fun onRegistrationSuccess(token: String)
        fun onRegistrationFailure(errorMessage: String)
    }
}
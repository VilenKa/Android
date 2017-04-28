package com.example.vilev.taxiapp42.Presenters

import com.example.vilev.taxiapp42.Presenters.Contracts.LoginContract
import com.example.vilev.taxiapp42.UseCases.LoginUseCase
import io.reactivex.observers.DisposableObserver

/**
 * Created by vilev on 12.04.2017.
 */
class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {

    private val loginUseCase: LoginUseCase = LoginUseCase()

    private fun createLoginObserver(): DisposableObserver<String> {
        return object : DisposableObserver<String>() {
            override fun onNext(login: String) {
                view.onLoginSuccess(login)
            }

            override fun onError(e: Throwable) {
                view.onLoginFailure(e.toString())
            }

            override fun onComplete() {

            }
        }
    }

    override fun onLogin(mobileNumber: String, password: String) {
        loginUseCase.execute(createLoginObserver(), LoginUseCase.Parameters(mobileNumber, password))
    }

}

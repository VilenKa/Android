package com.example.vilev.taxiapp42.Presenters

import com.example.vilev.taxiapp42.Presenters.Contracts.RegistrationContract
import com.example.vilev.taxiapp42.UseCases.RegistrationUseCase
import io.reactivex.observers.DisposableObserver

/**
 * Created by vilev on 14.04.2017.
 */
class RegistrationPresenter (val view: RegistrationContract.View) : RegistrationContract.Presenter {

    private val registrationUseCase: RegistrationUseCase = RegistrationUseCase()

    private fun createLoginObserver(): DisposableObserver<String> {
        return object : DisposableObserver<String>() {
            override fun onNext(token: String) {
                view.onRegistrationSuccess(token)
            }

            override fun onError(e: Throwable) {
                view.onRegistrationFailure(e.toString())
            }

            override fun onComplete() {

            }
        }
    }

    override fun onRegistration(login: String, password: String, surname:String, name:String, faculty:String, avatar:String) {
        registrationUseCase.execute(createLoginObserver(), RegistrationUseCase.Parameters(login, password, surname, name,faculty, avatar))
    }

}
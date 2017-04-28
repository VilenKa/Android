package com.example.vilev.taxiapp42.UseCases

/**
 * Created by vilev on 12.04.2017.
 */
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver


abstract class UseCase<Any, in Param>(workScheduler: Scheduler) {

    private var workScheduler: Scheduler? = workScheduler
    private var observer: DisposableObserver<Any>? = null
    fun execute(observer: DisposableObserver<Any>, parameters: Param) {
        this.observer = buildObservable(parameters)
                .subscribeOn(workScheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer)
    }

    fun dispose() {
        if (!observer!!.isDisposed) {
            observer!!.dispose()
        }
    }

    protected abstract fun buildObservable(parameters: Param): Observable<Any>

}
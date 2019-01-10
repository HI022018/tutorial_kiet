package com.example.tuankiet.mvpmodel.presenter

import com.example.tuankiet.mvpmodel.service.ApiCall
import com.example.tuankiet.mvpmodel.service.Repository
import com.example.tuankiet.mvpmodel.view.IView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Presenter(view: IView) {
    private var view:IView?= view
    fun requestApiVersion(){
        Repository.createService(ApiCall::class.java, null).getAboutUs()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {
                            result->
                                view?.displayResult(result.data)
                        },
                        {
                            error->
                                view?.displayResult(error.toString())
                        }
                )
    }
}

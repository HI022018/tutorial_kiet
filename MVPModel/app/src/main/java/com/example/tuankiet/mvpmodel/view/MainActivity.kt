package com.example.tuankiet.mvpmodel.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.tuankiet.mvpmodel.R
import com.example.tuankiet.mvpmodel.model.DataModel
import com.example.tuankiet.mvpmodel.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IView{
    private var presenter=Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.requestApiVersion()
    }
    override fun displayResult(data: String) {
        txtView.text=Html.fromHtml(data)
    }

}

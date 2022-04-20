package io.github.skillacademymvvm.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import io.github.skillacademymvvm.data.ResultResponse

class HomeAdapterViewModel(result: ResultResponse) : BaseObservable() {

    val title: String = result.title
        @Bindable get

    val overview: String = result.overview
        @Bindable get
}
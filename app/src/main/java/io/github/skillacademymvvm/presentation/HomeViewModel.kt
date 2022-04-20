package io.github.skillacademymvvm.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import io.github.skillacademymvvm.BR
import io.github.skillacademymvvm.data.HomeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomeViewModel(
    private val callback: HomeViewModelCallback,
    private val datasource: HomeDataSource,
) : BaseObservable(), HomeView {

    private val disposable: CompositeDisposable = CompositeDisposable()

    var progressBarVisibility: Int = View.GONE
        @Bindable get

    override fun discoverMovie() {
        progressBarVisibility = View.VISIBLE
        notifyPropertyChanged(BR.progressBarVisibility)

        datasource.discoverMovie().observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onSuccess(response.result)
                       }, { error ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onError(error)
            }).addTo(disposable)
    }

    override fun onDetach() {
        disposable.clear()
    }
}
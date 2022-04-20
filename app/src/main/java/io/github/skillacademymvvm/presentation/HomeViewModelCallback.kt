package io.github.skillacademymvvm.presentation

import io.github.skillacademymvvm.data.ResultResponse

interface HomeViewModelCallback {

    fun onSuccess(resultResponse: List<ResultResponse>)
    fun onError(error: Throwable)
}
package io.github.skillacademymvvm.data

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("result") val result: List<ResultResponse>
)

data class ResultResponse(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
)

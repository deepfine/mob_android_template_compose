package com.deepfine.network.extension

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.setBody
import io.ktor.http.parameters

fun HttpRequestBuilder.bodyParameters(vararg params: Pair<String, Any>) {
    setBody(
        FormDataContent(
            parameters {
                params.forEach { (name, value) ->
                    append(name, value.toString())
                }
            },
        ),
    )
}

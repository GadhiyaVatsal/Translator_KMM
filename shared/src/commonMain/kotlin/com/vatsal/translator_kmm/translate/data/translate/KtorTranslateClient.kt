package com.vatsal.translator_kmm.translate.data.translate

import com.vatsal.translator_kmm.core.domain.language.Language
import com.vatsal.translator_kmm.translate.domain.translate.TranslateClient
import com.vatsal.translator_kmm.translate.domain.translate.TranslateError
import com.vatsal.translator_kmm.translate.domain.translate.TranslateException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException

class KtorTranslateClient(
    private val httpClient: HttpClient
): TranslateClient {

    override suspend fun translate(
        formLanguage: Language,
        formText: String,
        toLanguage: Language
    ): String {
        val result = try {

            print("API CALL")
            httpClient.post {
                //https://libretranslate.com/translate
                url("https://translate.pl-coding.com/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = formText,
                        sourceLanguageCode = formLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }

        }catch (e: IOException){
            throw TranslateException(TranslateError.SERVER_ERROR)
        }

        when(result.status.value) {
            in 200..299 -> Unit
            500 -> throw TranslateException(TranslateError.SERVER_ERROR)
            in 400..499 -> throw TranslateException(TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
        }

        print("RESULT")
        print(result.body<TranslatedDto>().translatedText)

        return try {
            result.body<TranslatedDto>().translatedText
        } catch(e: Exception) {
            throw TranslateException(TranslateError.SERVER_ERROR)
        }
    }
}
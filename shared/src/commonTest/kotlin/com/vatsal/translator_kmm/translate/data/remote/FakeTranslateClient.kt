package com.vatsal.translator_kmm.translate.data.remote

import com.vatsal.translator_kmm.core.domain.language.Language
import com.vatsal.translator_kmm.translate.domain.translate.TranslateClient

class FakeTranslateClient: TranslateClient {

    var translatedText = "test translation"

    override suspend fun translate(
        formLanguage: Language,
        formText: String,
        toLanguage: Language
    ): String {
        return translatedText
    }
}
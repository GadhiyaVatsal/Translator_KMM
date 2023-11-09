package com.vatsal.translator_kmm.translate.domain.translate

import com.vatsal.translator_kmm.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        formLanguage: Language,
        formText: String,
        toLanguage: Language
    ): String
}
package com.vatsal.translator_kmm.core.presentation

import com.vatsal.translator_kmm.core.domain.language.Language

expect class UiLanguage {
    val language: Language

    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguage: List<UiLanguage>
    }
}
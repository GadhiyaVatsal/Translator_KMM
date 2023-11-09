package com.vatsal.translator_kmm.core.presentation

import com.vatsal.translator_kmm.core.domain.language.Language
import com.vatsal.translator_kmm.core.presentation.UiLanguage

actual class UiLanguage(
    actual val language: Language,
    val imageName: String
) {

    actual companion object {
        actual fun byCode(langCode: String): UiLanguage {
            return allLanguage.find { it.language.langCode == langCode }
                ?: throw IllegalArgumentException("Invalid or unsupported language code")
        }

        actual val allLanguage: List<UiLanguage>
            get() = Language.values().map { language ->
                com.vatsal.translator_kmm.translate.presentation.UiLanguage(
                    language = language,
                    imageName = language.langName.lowercase()
                )
            }
    }
}
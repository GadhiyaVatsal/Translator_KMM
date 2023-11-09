package com.vatsal.translator_kmm.core.domain.util

import kotlinx.coroutines.flow.StateFlow

class CommonStateFlow<T>(
    private val flow: StateFlow<T>
) : StateFlow<T> by flow
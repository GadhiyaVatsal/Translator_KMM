package com.vatsal.translator_kmm.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

class IOSMutableSateFlow<T> (
    initialValue: T
): CommonMutableStateFlow<T>(MutableStateFlow(initialValue))
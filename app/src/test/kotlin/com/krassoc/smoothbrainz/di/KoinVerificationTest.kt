package com.krassoc.smoothbrainz.di

import org.junit.Test
import org.koin.android.test.verify.androidVerify

class KoinVerificationTest {

    @Test
    fun verify(){
        appModule.androidVerify()
    }
}
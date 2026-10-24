package com.krassoc.smoothbrainz.di

import org.junit.Test
import org.koin.android.test.verify.androidVerify

import com.krassoc.smoothbrainz.di.appModule

class KoinVerificationTest {

    @Test
    fun verify(){
        appModule.androidVerify()
    }
}
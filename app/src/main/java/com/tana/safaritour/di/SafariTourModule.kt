package com.tana.safaritour.di

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tana.safaritour.authentication.signup.data.RegistrationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SafariTourModule {

    @Provides
    @Singleton
    fun provideRepository(
        firebaseAuth: FirebaseAuth,
        currentUser: MutableLiveData<FirebaseUser?>,
        errorMessage: MutableLiveData<String?>
    ): RegistrationRepository {
        return RegistrationRepository(
            auth = firebaseAuth,
            currentUser = currentUser,
            errorMessage = errorMessage
        )
    }

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideErrorMessage(): MutableLiveData<String?> {
        return MutableLiveData()
    }

    @Provides
    fun provideCurrentUser(): MutableLiveData<FirebaseUser?> {
        return MutableLiveData()
    }
}
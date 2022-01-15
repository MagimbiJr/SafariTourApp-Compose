package com.tana.safaritour.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
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
        database: FirebaseFirestore,
        currentUser: MutableLiveData<FirebaseUser?>,
        errorMessage: MutableLiveData<String?>
    ): RegistrationRepository {
        return RegistrationRepository(
            auth = firebaseAuth,
            database = database,
            currentUser = currentUser,
            errorMessage = errorMessage
        )
    }

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideFirestoreDb(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    fun provideErrorMessage(): MutableLiveData<String?> {
        return MutableLiveData()
    }

    @Provides
    fun provideCurrentUser(): MutableLiveData<FirebaseUser?> {
        return MutableLiveData()
    }

//    @Provides
//    @Composable
//    fun provideNavController(): NavHostController = rememberNavController()
}
package com.tana.safaritour.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.tana.safaritour.authentication.signup.data.RegistrationRepository
import com.tana.safaritour.bottom_nav.home.data.Place
import com.tana.safaritour.bottom_nav.home.data.PlacesRepository
import com.tana.safaritour.bottom_nav.home.data.PlacesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Named
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
    @Singleton
    fun providePlacesRepository(
        db: FirebaseFirestore,
        places: MutableLiveData<List<Place>>,
        popularPlaces: MutableLiveData<List<Place>>,
        loading: Boolean,
        //errorMessage: MutableLiveData<String>
    ): PlacesRepository {
        return PlacesRepositoryImpl(
            db = db,
            places = places,
            popularPlaces = popularPlaces,
            loading = loading,
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

//    @Provides
//    fun provideErrorMessage(): MutableLiveData<String?> {
//        return MutableLiveData()
//    }

    @Provides
    fun provideLoading(): Boolean {
        return false
    }

    @Provides
    fun provideCurrentUser(): MutableLiveData<FirebaseUser?> {
        return MutableLiveData()
    }

    @Provides
    //@Named("Places")
    fun providePlaces(): MutableLiveData<List<Place>> {
        return MutableLiveData(listOf())
    }

//    @Provides
//    fun provideLoading(): MutableLiveData<Boolean> {
//        return MutableLiveData()
//    }
}
package com.ElOuedUniv.maktaba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ElOuedUniv.maktaba.presentation.navigation.NavGraph
import com.ElOuedUniv.maktaba.presentation.navigation.Screen
import com.ElOuedUniv.maktaba.presentation.theme.MaktabaTheme
import com.ElOuedUniv.maktaba.utlis.DataStoreManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var dataStoreManager: DataStoreManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            val isOnboardingCompleted by dataStoreManager.getOnBoarding().collectAsState(initial = null)
            
            MaktabaTheme {
                if (isOnboardingCompleted != null) {
                    NavGraph(
                        startDestination = if (isOnboardingCompleted == true) {
                            Screen.BookList.route
                        } else {
                            Screen.Onboarding.route
                        }
                    )
                }
            }
        }
    }
}

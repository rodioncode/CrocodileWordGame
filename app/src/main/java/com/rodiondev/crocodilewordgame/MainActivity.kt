package com.rodiondev.crocodilewordgame

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.rodiondev.crocodilewordgame.ui.screens.ApplicationScreen
import com.rodiondev.crocodilewordgame.ui.theme.CrocodileWordGameTheme
import dagger.hilt.android.AndroidEntryPoint


/**
 * @author - Rodion Dubanov https://github.com/rodioncode
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrocodileWordGameTheme {
                ApplicationScreen()
            }
        }
    }
}
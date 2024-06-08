package com.practice.composeui.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.composeui.ui.screen.DropDownAnim
import com.practice.composeui.ui.screen.LoginScreen
import com.practice.composeui.ui.screen.ProfileScreen
import com.practice.composeui.ui.screen.ProfileSection
import com.practice.composeui.ui.screen.RegisterScreen
import com.practice.composeui.ui.screen.ShakingState
import com.practice.composeui.ui.screen.rememberShakeButton
import com.practice.composeui.ui.screen.shakable
import com.practice.composeui.ui.theme.ComposeUITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //installSplashScreen()

        setContent {
            ComposeUITheme {
                /*Surface(
                  color = Color(0xFF101010),
                  modifier = Modifier.fillMaxSize()
                ) {
                   DropDownAnim(
                       text = "Hello World!",
                       modifier = Modifier.padding(16.dp)
                   ) {
                      Text(
                          text = "This is now revealed!",
                          color = Color.White,
                          modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Green)
                      )
                   }
                }*/

                //ProfileScreen()
/*                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                    val shakingState = rememberShakeButton(
                      strength = ShakingState.Strength.Custom(60f),
                      directions = ShakingState.Directions.RIGHT_THEN_LEFT
                    )
                    val scope  = rememberCoroutineScope()

                    TextButton(
                        onClick = {
                            scope.launch {
                              shakingState.shake(animDuration = 30)
                            }
                        },
                        modifier = Modifier.shakable(shakingState)
                     ) {
                        Text(text = "Click Button To Shake", fontSize = 22.sp)
                    }
                }*/
            }
        }
    }
}

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login Screen"){
        composable("Login Screen"){
            LoginScreen(navController)
        }
        composable("Register Screen") {
            RegisterScreen()
        }
    }
}


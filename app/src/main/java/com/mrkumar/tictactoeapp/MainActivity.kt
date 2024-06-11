package com.mrkumar.tictactoeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mrkumar.tictactoeapp.screens.TicTacToeScreen
import com.mrkumar.tictactoeapp.ui.theme.TicTacToeAppTheme
import com.mrkumar.tictactoeapp.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeAppTheme {
                Surface {
                    val viewModel= viewModel<GameViewModel>()
                    TicTacToeScreen(viewModel = viewModel)
                }
            }
        }
    }
}


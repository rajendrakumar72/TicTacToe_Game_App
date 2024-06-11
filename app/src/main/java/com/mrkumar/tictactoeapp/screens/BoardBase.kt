package com.mrkumar.tictactoeapp.screens

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrkumar.tictactoeapp.ui.theme.Aqua
import com.mrkumar.tictactoeapp.ui.theme.GreenishYellow
import kotlinx.coroutines.delay
import java.io.IOException

@Composable
fun BoardBase() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width / 3, y = 0f),
            end = Offset(x = size.width / 3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 2 / 3, y = 0f),
            end = Offset(x = size.width * 2 / 3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height / 3),
            end = Offset(x = size.width, y = size.height / 3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 2 / 3),
            end = Offset(x = size.width, y = size.height * 2 / 3)
        )
    }
}

@Composable
fun Circle() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color = Aqua,
            style = Stroke(width = 20f)
        )
    }
}

@Composable
fun Cross() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawLine(
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )
        drawLine(
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = 0f)
        )
    }
}

@Composable
fun WinVerticalLine1() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/6, y = 0f),
            end = Offset(x = size.width*1/6, y = size.height)
        )
    }
}

@Composable
fun WinVerticalLine2() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*3/6, y = 0f),
            end = Offset(x = size.width*3/6, y = size.height)
        )
    }
}

@Composable
fun WinVerticalLine3() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*5/6, y = 0f),
            end = Offset(x = size.width*5/6, y = size.height)
        )
    }
}

@Composable
fun WinHorizontalLine1() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*1/6),
            end = Offset(x = size.width, y = size.height*1/6)
        )
    }
}

@Composable
fun WinHorizontalLine2() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*3/6),
            end = Offset(x = size.width, y = size.height*3/6)
        )
    }
}

@Composable
fun WinHorizontalLine3() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*5/6),
            end = Offset(x = size.width, y = size.height*5/6)
        )
    }
}

@Composable
fun WinDiagonalLine1() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )
    }
}

@Composable
fun WinDiagonalLine2() {
    playAudio()
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = 0f)
        )
    }
}

@Composable
fun playAudio() {
    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var isPlaying by remember { mutableStateOf(false) }

    if (mediaPlayer == null) {
        mediaPlayer = MediaPlayer().apply {
            try {
                // Open the file descriptor for the asset
                val afd = context.assets.openFd("game_over.wav")
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                afd.close()

                // Prepare the MediaPlayer asynchronously
                setOnPreparedListener { start() }
                prepareAsync()
                isPlaying = true

                // Set an OnCompletionListener to reset the state when playback finishes
                setOnCompletionListener {
                    isPlaying = false
                    mediaPlayer?.release()
                    mediaPlayer = null
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        DisposableEffect(Unit) {
            onDispose {
                mediaPlayer?.pause()
            }
        }
    }
}







@Preview(showBackground = true)
@Composable
fun Prevs() {
    WinVerticalLine1()
    WinVerticalLine2()
    WinVerticalLine3()
    WinHorizontalLine1()
    WinHorizontalLine2()
    WinHorizontalLine3()
    WinDiagonalLine1()
    WinDiagonalLine2()
}
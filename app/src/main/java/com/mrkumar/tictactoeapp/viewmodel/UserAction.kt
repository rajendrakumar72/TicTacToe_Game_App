package com.mrkumar.tictactoeapp.viewmodel

sealed class UserAction {
    object PlayAgainButtonClicked:UserAction()
    data class BoardTapped(val cellNo:Int):UserAction()
}
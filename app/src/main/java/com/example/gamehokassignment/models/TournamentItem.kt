package com.example.gamehokassignment.models

import java.util.UUID

data class TournamentItem(val id:String,val name:String,val image:String){
    companion object{
        fun getMockData():List<TournamentItem>{
            return arrayListOf(
                TournamentItem(
                    image = "android.resource://com.example.gamehokassignment/drawable/image_124",
                    id = UUID.randomUUID().toString(),
                    name = "PUBG"
                ),
                TournamentItem(
                    image = "android.resource://com.example.gamehokassignment/drawable/image_135",
                    id = UUID.randomUUID().toString(),
                    name = "Valorant"
                ),
                TournamentItem(
                    image = "android.resource://com.example.gamehokassignment/drawable/image_133",
                    id = UUID.randomUUID().toString(),
                    name = "Counter Strike"
                ),
                TournamentItem(
                    image = "android.resource://com.example.gamehokassignment/drawable/image_131",
                    id = UUID.randomUUID().toString(),
                    name = "Call of Duty"
                ),
                TournamentItem(
                    image = "android.resource://com.example.gamehokassignment/drawable/image_132",
                    id = UUID.randomUUID().toString(),
                    name = "Apex Legends"
                ),
                TournamentItem(
                    image = "android.resource://com.example.gamehokassignment/drawable/image_124",
                    id = UUID.randomUUID().toString(),
                    name = "PUBG"
                ),
            )}
    }
}
package com.example.gamehokassignment.models

import android.content.Context
import com.example.gamehokassignment.R
import java.util.UUID

data class TournamentsBattle(
    val id: String,
    val registrationStatus: String,
    val coinsAmount: String,
    val tournamentTitle: String,
    val date: String,
    val entry: String,
    val teamSize: String,
    val tournamentDetails: String,
    val tournamentImage: String,
) {
    companion object {
        fun getMockData(context: Context): List<TournamentsBattle> {
            val battleTournamentlist = arrayListOf(
                TournamentsBattle(
                    id = UUID.randomUUID().toString(),
                    registrationStatus = "Registration Open",
                    coinsAmount = "10000",
                    tournamentTitle = context.getString(R.string.example_tournament_title),
                    date = context.getString(R.string.jun_26_jun_27_2024),
                    entry = context.getString(R.string.example_entry),
                    teamSize = context.getString(R.string.example_team_size),
                    tournamentDetails = context.getString(R.string.see_tournament_details),
                    tournamentImage = "android.resource://com.example.gamehokassignment/drawable/image_121" // Assuming this is the drawable name
                ),
                TournamentsBattle(
                    id = UUID.randomUUID().toString(),
                    registrationStatus = "Registration Open",
                    coinsAmount = "10000",
                    tournamentTitle = context.getString(R.string.example_tournament_title),
                    date = context.getString(R.string.jun_26_jun_27_2024),
                    entry = context.getString(R.string.example_entry),
                    teamSize = context.getString(R.string.example_team_size),
                    tournamentDetails = context.getString(R.string.see_tournament_details),
                    tournamentImage = "android.resource://com.example.gamehokassignment/drawable/image_121" // Assuming this is the drawable name
                ),
                TournamentsBattle(
                    id = UUID.randomUUID().toString(),
                    registrationStatus = "Registration Open",
                    coinsAmount = "10000",
                    tournamentTitle = context.getString(R.string.example_tournament_title),
                    date = context.getString(R.string.jun_26_jun_27_2024),
                    entry = context.getString(R.string.example_entry),
                    teamSize = context.getString(R.string.example_team_size),
                    tournamentDetails = context.getString(R.string.see_tournament_details),
                    tournamentImage = "android.resource://com.example.gamehokassignment/drawable/image_121" // Assuming this is the drawable name
                ),
                TournamentsBattle(
                    id = UUID.randomUUID().toString(),
                    registrationStatus = "Registration Open",
                    coinsAmount = "10000",
                    tournamentTitle = context.getString(R.string.example_tournament_title),
                    date = context.getString(R.string.jun_26_jun_27_2024),
                    entry = context.getString(R.string.example_entry),
                    teamSize = context.getString(R.string.example_team_size),
                    tournamentDetails = context.getString(R.string.see_tournament_details),
                    tournamentImage = "android.resource://com.example.gamehokassignment/drawable/image_121" // Assuming this is the drawable name
                ),

                )

            return battleTournamentlist

        }
    }
}

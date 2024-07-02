package com.example.gamehokassignment.models

data class UserItem(
    val id: String,
    val name: String,
    val image: String
){
    companion object{
        fun mockUserItems() = arrayListOf(
            UserItem(
                id = "1",
                name = "Ninja",
                image = "android.resource://com.example.gamehokassignment/drawable/user_profile"
            ),
            UserItem(
                id = "2",
                name = "Shroud",
                image = "android.resource://com.example.gamehokassignment/drawable/user3"
            ),
            UserItem(
                id = "3",
                name = "DrDisRespect",
                image = "android.resource://com.example.gamehokassignment/drawable/user2"
            ),
            UserItem(
                id = "4",
                name = "PewDiePie",
                image = "android.resource://com.example.gamehokassignment/drawable/user3"
            ),)
    }
}
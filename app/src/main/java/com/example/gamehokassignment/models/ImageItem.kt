package com.example.gamehokassignment.models

import java.util.UUID

data class ImageItem(
    val id:String,
    val url:String
){
    companion object{
         fun mockImageItems():List<ImageItem>{
            return arrayListOf(
                ImageItem(
                    UUID.randomUUID().toString(),
                    "android.resource://com.example.gamehokassignment/drawable/image_136"
                ),
                ImageItem(
                    UUID.randomUUID().toString(),
                    "android.resource://com.example.gamehokassignment/drawable/image_136"
                ),
                ImageItem(
                    UUID.randomUUID().toString(),
                    "android.resource://com.example.gamehokassignment/drawable/image_136"
                ),
            )
        }
    }
}

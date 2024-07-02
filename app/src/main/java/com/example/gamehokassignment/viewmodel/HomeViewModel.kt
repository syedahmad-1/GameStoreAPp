package com.example.gamehokassignment.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamehokassignment.models.ImageItem
import com.example.gamehokassignment.models.TournamentItem
import com.example.gamehokassignment.models.TournamentsBattle
import com.example.gamehokassignment.models.UserItem

class HomeViewModel : ViewModel() {

    private val _images = MutableLiveData<List<ImageItem>>()
    val images: LiveData<List<ImageItem>> get() = _images

    private val _tournamentImages = MutableLiveData<List<TournamentItem>>()
    val tournamentImages: LiveData<List<TournamentItem>> get() = _tournamentImages

    private val _battleTournament = MutableLiveData<List<TournamentsBattle>>()
    val battleTournament: LiveData<List<TournamentsBattle>> get() = _battleTournament

    private val _userList = MutableLiveData<List<UserItem>>()
    val userList: LiveData<List<UserItem>> get() = _userList

    fun loadMockData(context: Context) {
        _images.value = ImageItem.mockImageItems()
        _tournamentImages.value = TournamentItem.getMockData()
        _battleTournament.value = TournamentsBattle.getMockData(context)
        _userList.value = UserItem.mockUserItems()
    }
}

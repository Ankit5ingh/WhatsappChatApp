package com.ankit.chatapp.data.repository

import androidx.lifecycle.LiveData
import com.ankit.chatapp.data.model.User
import com.ankit.chatapp.data.source.firebase.ChatRoomListLiveData
import com.ankit.chatapp.data.source.firebase.ChatRoomLiveData
import com.ankit.chatapp.utils.states.AuthenticationState
import com.ankit.chatapp.utils.states.NetworkState

interface Repository {

    fun getChatRoomListLiveData(): ChatRoomListLiveData

    fun getChatRoomLiveData(): ChatRoomLiveData

    fun getUserLiveData(): LiveData<Pair<User?, AuthenticationState>>

    suspend fun isUsernameAvailable(
        username: String,
        callBack: (networkState: NetworkState) -> Unit
    )

    suspend fun searchForUser(
        username: String,
        callBack: (networkState: NetworkState, userList: MutableList<User>) -> Unit
    )

    fun addUsername(
        username: String,
        callBack: (usernameStatus: NetworkState) -> Unit
    )

    fun fetchConfigMsgLength(callBack: (msgLengh: Int) -> Unit)
}
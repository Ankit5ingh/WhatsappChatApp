package com.ankit.chatapp.utils.states

sealed class AuthenticationState {
    class Authenticated(val userId: String) : AuthenticationState()
    object Unauthenticated : AuthenticationState()
    object InvalidAuthentication : AuthenticationState()
}
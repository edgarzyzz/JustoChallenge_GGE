package com.gogaedd.edgargonzalezjustochallenge.listener

import com.gogaedd.edgargonzalezjustochallenge.model.Friend

interface FriendListener {
    fun onDeleteFriend(friendToDelete: Friend)
    fun onShowDetailFriend(friend: Friend)
}
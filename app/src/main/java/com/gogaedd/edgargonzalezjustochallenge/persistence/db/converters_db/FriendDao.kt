package com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db

import androidx.room.*
import com.gogaedd.edgargonzalezjustochallenge.model.Friend

@Dao
interface FriendDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFriend(friend: Friend)

    @Delete
    fun deleteFriend(friend: Friend)

    @Query("select * from Friend")
    fun getAllFriends(): MutableList<Friend>

    @Query("select * from Friend where emailMainUserFriend = :email")
    fun getFriendsByEmail(email: String):MutableList<Friend>

    @Query("delete from friend where emailMainUserFriend = :emailUserDeleted")
    fun deleteAllFriendsByUser(emailUserDeleted: String)



}
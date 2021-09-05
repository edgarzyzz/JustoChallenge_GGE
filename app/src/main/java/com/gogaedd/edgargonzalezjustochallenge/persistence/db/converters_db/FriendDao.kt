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

    @Query("select * from Friend where email = :email")
    fun getFriendByEmail(email: String):Friend

    @Query("delete from friend where emailMainUserFriend = :emailUserDeleted")
    fun deleteAllFriendsByUser(emailUserDeleted: String)



}
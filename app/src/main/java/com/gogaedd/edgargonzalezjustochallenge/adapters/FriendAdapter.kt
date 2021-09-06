package com.gogaedd.edgargonzalezjustochallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gogaedd.edgargonzalezjustochallenge.databinding.ItemFriendBinding
import com.gogaedd.edgargonzalezjustochallenge.listener.FriendListener
import com.gogaedd.edgargonzalezjustochallenge.model.Friend

class FriendAdapter() : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    var mListFriends: MutableList<Friend> = mutableListOf()
    var mListener: FriendListener? = null

    fun setListener(listener: FriendListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendBinding.inflate(inflater, parent, false)

        return FriendViewHolder(binding, mListener)

    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) =
        holder.bind(mListFriends[position])

    override fun getItemCount(): Int = mListFriends.size

    class FriendViewHolder(val binding: ItemFriendBinding, val mListener: FriendListener?) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: Friend) {
            binding.friend = friend
            binding.ibtnDeleteItmf.setOnClickListener { mListener?.onDeleteFriend(friend) }
        }
    }
}
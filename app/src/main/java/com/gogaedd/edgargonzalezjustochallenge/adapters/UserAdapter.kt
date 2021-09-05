package com.gogaedd.edgargonzalezjustochallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gogaedd.edgargonzalezjustochallenge.databinding.ItemUserBinding
import com.gogaedd.edgargonzalezjustochallenge.listener.UserRegsitreredListener
import com.gogaedd.edgargonzalezjustochallenge.model.Person

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    val mListUsers: MutableList<Person> = mutableListOf()
    var mListener: UserRegsitreredListener? =null



    fun setListener(listener: UserRegsitreredListener){
        mListener = listener

    }

    fun updateData(updateElements: MutableList<Person>){
        mListUsers.clear()
        mListUsers.addAll(updateElements)
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflate, parent, false)
        return UserViewHolder(binding, mListener)


    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =holder.bind(mListUsers[position])

    override fun getItemCount(): Int = mListUsers.size

    class UserViewHolder(val binding: ItemUserBinding, val mListener: UserRegsitreredListener?) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Person) {
            binding.person = user
            binding.root.setOnClickListener {
                mListener?.onUserSelected(user)
            }

        }

    }
}
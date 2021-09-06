package com.gogaedd.edgargonzalezjustochallenge.utils

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gogaedd.edgargonzalezjustochallenge.adapters.FriendAdapter
import com.gogaedd.edgargonzalezjustochallenge.adapters.NearPersonAdapter
import com.gogaedd.edgargonzalezjustochallenge.adapters.UserAdapter
import com.gogaedd.edgargonzalezjustochallenge.model.Friend
import com.gogaedd.edgargonzalezjustochallenge.model.Name
import com.gogaedd.edgargonzalezjustochallenge.model.Person

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("data")
    fun getData(recycler: RecyclerView, listUsers: MutableList<Person>) {
        recycler.adapter?.let { adapterNotNull ->
            if (adapterNotNull is UserAdapter) {
                adapterNotNull.updateData(listUsers)
            }

        }
    }

    @JvmStatic
    @BindingAdapter("dataRandomPeople")
    fun dataRandomPeople(recylcer:RecyclerView, listRandoPeople:MutableList<Person> ){
        recylcer.adapter?.let {
            if (it is NearPersonAdapter){
                it.updateElements(listRandoPeople)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("dataFriend")
    fun dataFriend(recylcer:RecyclerView, listFriends:MutableList<Friend>){

        recylcer.adapter?.let{
            if (it is FriendAdapter){
                it.updateElements(listFriends)
            }
        }

    }


    @JvmStatic
    @BindingAdapter("drawImageByUrl")
    fun drawImageByUrl(imageView: ImageView, url: String) {
        url?.let {
            Glide.with(imageView.context)
                .load(url)
                .circleCrop()
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("fullName")
    fun fullName(tv: TextView, name: Name) {
        tv.text = "${name.first} ${name.last} ${name.title} "
    }

    @JvmStatic
    @BindingAdapter("setEnableByLimMaxElements")
    fun setEnableByLimMaxElements(btn: Button, list: List<*>) {
        val enable = list.isNullOrEmpty() || list.size <= 3

        btn.isEnabled = enable
    }

    @JvmStatic
    @BindingAdapter("visibilityRecyclerByElements")
    fun visibilityRecyclerByElements(view: View, list: List<*>) {
        val visibility = if (list.isNullOrEmpty()) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }

        view.visibility = visibility

    }

    @JvmStatic
    @BindingAdapter("visibilityMsgEmptyDataByElements")
    fun visibilityMsgEmptyDataByElements(view: View, list: List<*>) {
        val visibility = if (list.isNullOrEmpty()) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }

        view.visibility = visibility

    }

    @JvmStatic
    @BindingAdapter("textNumberFriends")
    fun textNumberFriends(textview:TextView, list:List<*>){
        val number = if (list.isNullOrEmpty()){
            "0"
        }else{
            list.size.toString()
        }


        textview.text = "Amigos: $number"
    }
}
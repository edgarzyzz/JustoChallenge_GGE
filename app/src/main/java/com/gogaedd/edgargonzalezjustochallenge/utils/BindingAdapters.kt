package com.gogaedd.edgargonzalezjustochallenge.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gogaedd.edgargonzalezjustochallenge.adapters.UserAdapter
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
    fun fullName(tv: TextView, name: Name){
        tv.text = "${name.first} ${name.last} ${name.title} "
    }

}
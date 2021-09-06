package com.gogaedd.edgargonzalezjustochallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gogaedd.edgargonzalezjustochallenge.databinding.ItemNearPersonBinding
import com.gogaedd.edgargonzalezjustochallenge.listener.NearPersonListener
import com.gogaedd.edgargonzalezjustochallenge.model.Person

class NearPersonAdapter(): RecyclerView.Adapter<NearPersonAdapter.NearPersonViewHolder>() {
    var mlistNearPerson : MutableList<Person> = mutableListOf()

    var mlistener: NearPersonListener? = null


    fun setListener(listener:NearPersonListener){
        mlistener = listener

    }

    fun updateElements(listUpdated :MutableList<Person>){
        mlistNearPerson.clear()
        mlistNearPerson.addAll(listUpdated)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearPersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNearPersonBinding.inflate(inflater, parent, false)
        return NearPersonViewHolder(binding, mlistener)

    }

    override fun onBindViewHolder(holder: NearPersonViewHolder, position: Int) = holder.bind(mlistNearPerson[position])

    override fun getItemCount(): Int = mlistNearPerson.size

    class NearPersonViewHolder(val binding: ItemNearPersonBinding,val  mlistener: NearPersonListener?):RecyclerView.ViewHolder(binding.root){
        fun bind(nearperson: Person){
            binding.person = nearperson
            binding.btnAddItmp.setOnClickListener{
                mlistener?.onAddNearperson(nearperson)
            }
            binding.root.setOnClickListener {
                mlistener?.onShowDetailNearPerson(nearperson)
            }
        }

    }


}
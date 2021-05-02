package com.latiff.nutrition.ui.ingredient

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.latiff.nutrition.R
import com.latiff.nutrition.databinding.IngredientItemBinding
import com.latiff.nutrition.models.Ingredients
import com.latiff.nutrition.models.ParsedModel

class IngredientsAdapter(val list: MutableList<Ingredients>) : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflate: IngredientItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.ingredient_item, parent, false
        )
        return MyViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        list.get(position).parsed?.get(0)?.let {
            holder.binding.model=it
        }
    }

    override fun getItemCount(): Int =list.size
}
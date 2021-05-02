package com.latiff.nutrition.ui.ingredient

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.latiff.nutrition.R
import com.latiff.nutrition.databinding.FragmentIngredientBinding
import com.latiff.nutrition.models.Ingredients
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.models.ParsedModel
import com.latiff.nutrition.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientFragment : BaseFragment<IngredientViewModel,FragmentIngredientBinding>() {

    lateinit var model: NutritionDetails

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model= arguments?.get("NutritionDetails") as NutritionDetails
        viewModel.getListOfIngredients(model).observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                binding.list.layoutManager = LinearLayoutManager(activity)
                binding.list.adapter = IngredientsAdapter(it as MutableList<Ingredients>)

            }
        })

        binding.nextBtn.setOnClickListener {
            navController.navigate(R.id.intent_to_fragment_nutrition, arguments)
        }
    }
    override fun setBindingView(inflater: LayoutInflater): FragmentIngredientBinding {
        return  DataBindingUtil.inflate(
            inflater, R.layout.fragment_ingredient, null, false
        )
    }

}
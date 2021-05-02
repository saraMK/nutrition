package com.latiff.nutrition.ui.nutrition

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.latiff.nutrition.R
import com.latiff.nutrition.databinding.FragmentNutritionBinding
import com.latiff.nutrition.models.Ingredients
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.ui.base.BaseFragment
import com.latiff.nutrition.ui.ingredient.IngredientsAdapter
import com.latiff.nutrition.utiles.Utiles
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionFragment : BaseFragment<NutritionViewModel,FragmentNutritionBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = arguments?.get("NutritionDetails") as NutritionDetails
            viewModel.getDelayNutritionDetails(model)

    }
    override fun setBindingView(inflater: LayoutInflater): FragmentNutritionBinding {
          return DataBindingUtil.inflate(
            inflater, R.layout.fragment_nutrition, null, false
        )
    }


}
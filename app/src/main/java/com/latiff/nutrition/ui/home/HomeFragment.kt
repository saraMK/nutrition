package com.latiff.nutrition.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.latiff.nutrition.ui.base.BaseFragment
import com.latiff.nutrition.R
import com.latiff.nutrition.databinding.FragmentHomeBinding
import com.latiff.nutrition.utiles.Utiles
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            viewModel.nutritionDetailsLiveData.observe(viewLifecycleOwner, Observer {

                if (it != null) {
                    val bundle = Bundle()
                    bundle.putSerializable("NutritionDetails", it)
                    navController.navigate(R.id.intent_to_fragment_ingredient, bundle)
                }
            })


    }


    override fun setBindingView(inflater: LayoutInflater): FragmentHomeBinding {
        return DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, null, false
        )
    }


}
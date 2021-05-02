package com.latiff.nutrition.ui.base

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.latiff.nutrition.BR
import com.latiff.nutrition.R
import com.latiff.nutrition.utiles.Utiles

import javax.inject.Inject


open abstract class BaseFragment<viewmodel : BaseViewModel, viewbinding : ViewDataBinding>() :
    Fragment(), BaseView<viewbinding> {
    @Inject
    lateinit var viewModel: viewmodel
    lateinit var binding: viewbinding
    lateinit var navController: NavController
    var initialized=false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

         if (!::binding.isInitialized) {
            binding = setBindingView(inflater)
            binding.executePendingBindings()
            binding.lifecycleOwner = this
            binding?.setVariable(BR.viewModel, viewModel)
        }
         return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        viewModel.errorMsg_.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty())
                 toastMsg_Warning(it, binding.root)
        })

        Utiles.log_D("mmdmdmdmdmd222","$savedInstanceState")
    }
    fun toastMsg_Warning(msg: String, view: View) {
        try {
            val snackbar = Snackbar.make(
                view, msg,
                Snackbar.LENGTH_LONG
            ).setAction("Action", null)
            snackbar.setActionTextColor(Color.BLUE)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundResource(R.color.white)
            val textView =
                snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            textView.textSize = 15f
            textView.gravity = Gravity.CENTER
            textView.maxLines = 1
            textView.compoundDrawablePadding = 20

            snackbar.show()
        } catch (e: Exception) {
        }
    }

}
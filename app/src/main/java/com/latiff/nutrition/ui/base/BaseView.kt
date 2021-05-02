package com.latiff.nutrition.ui.base

import android.content.Context
import android.graphics.Color
import android.graphics.Color.red
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar

open interface BaseView<B : ViewDataBinding> {

    fun setBindingView(inflater: LayoutInflater): B


}
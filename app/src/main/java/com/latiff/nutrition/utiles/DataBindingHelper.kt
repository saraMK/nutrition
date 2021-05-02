package com.latiff.nutrition.utiles

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.math.RoundingMode

object DataBindingHelper {

    @BindingAdapter("setErrorMsg")
    @JvmStatic
    open fun setErrorMsg(editText: EditText, msg: Int) {
        editText.error = if (msg == 0) null else editText.context.getString(msg)
    }

    @BindingAdapter(value = ["numberRounded", "unitMeasure"])
    @JvmStatic
    open fun roundToDouble(editText: TextView, numberRounded: Double?, unitMeasure: String?) {
         val rounded = numberRounded?.let {
             it.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
         }
        editText.setText("$rounded $unitMeasure")
    }
}
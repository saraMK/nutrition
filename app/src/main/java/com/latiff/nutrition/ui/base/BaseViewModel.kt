package com.latiff.nutrition.ui.base

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.latiff.nutrition.network.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

open class BaseViewModel() : ViewModel() {
    private val networkErrorMsgEn = "No Connection !!"



    protected var errorMsg = MutableLiveData<String>("")
    val errorMsg_: LiveData<String>
        get() = errorMsg
     var loader = ObservableField<Boolean>(false)



    public fun <T> resetLiveData(liveData: MutableLiveData<T>) {
        liveData.value = null
    }
    protected suspend fun getErrorMsg(result: ResultWrapper<Any>) {
        withContext(Dispatchers.Main) {
             when (result) {
                is ResultWrapper.NetworkError -> errorMsg.value =
                   networkErrorMsgEn
                is ResultWrapper.GenericError -> errorMsg.value = result.error!!.message

            }
            resetLiveData(errorMsg)
        }
    }

    protected suspend fun getErrorMsgString(result: String) {
        withContext(Dispatchers.Main) {
            errorMsg.value = result


        }
    }
}
package com.curso.android.app.practica.compare_txt.view
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.compare_txt.model.CompareData

//import com.curso.android.app.practica.compare_txt.model.CompareData

class MainViewModel:ViewModel() {

    val compareData:LiveData<CompareData> get() = _compareData
    private var _compareData = MutableLiveData<CompareData>(CompareData("Comparar Texto..."))

    fun compareTxt(value1:String, value2:String){
            if(value1 == value2) {
                updateResult("LOS TEXTOS SON IGUALES!!")
            }else{
                updateResult("LOS TEXTOS SON DISTINTOS!!")
    }
    }

    fun updateResult(result: String){
        _compareData.value = CompareData(result)
    }
}
package com.latiff.nutrition.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.latiff.nutrition.MainCoroutineRule
import com.latiff.nutrition.R
import com.latiff.nutrition.getOrAwaitValueTest
import com.latiff.nutrition.models.AnalysisModelRequest
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.network.ResultWrapper
import com.latiff.nutrition.network.repo.FakeDataRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel : HomeViewModel


    @Before
    fun setup() {
        viewModel = HomeViewModel(FakeDataRepo())
    }

    @Test
    fun `click analysis with empty text returns error`() {
        viewModel.ingredients.set("")
        viewModel.getAnalysisList()
        val value = viewModel.errorMsgField.getOrAwaitValueTest()
        assertThat(value).isEqualTo(R.string.required)
    }

    @Test
    fun `click analysis with empty lines returns error`() {
        viewModel.ingredients.set("\n \n \n")
        viewModel.getAnalysisList()
        val value = viewModel.errorMsgField.getOrAwaitValueTest()
        assertThat(value).isEqualTo(R.string.required)
    }

    @Test
    fun `click analysis with text and empty lines returns text only`() {
        val text ="1 cup rice"
        viewModel.ingredients.set("$text \n \n \n")
        viewModel.getAnalysisList()
        val value = viewModel.ingredientsList.get(0)
        assertThat(value).isEqualTo(text)

    }
    @Test
    fun `click analysis with more text and empty lines returns list size equale number of texts`() {
        val text ="1 cup rice"
        val text2 ="1 cup rice"
        val text3 ="1 cup rice"
        viewModel.ingredients.set("$text \n $text2\n $text3 \n\n\n\n")
        viewModel.getAnalysisList()
        val value = viewModel.ingredientsList
        assertThat(value.size).isEqualTo(3)

    }


    @Test
    fun `click analysis with text and get nutrition details `() {
        val text ="1 cup rice"
        val list= mutableListOf(text)
        val modelRequest=AnalysisModelRequest(list)
        runBlocking {
          val result=  viewModel.repo.analysisIngredients(modelRequest)
            assertThat(result).isEqualTo(ResultWrapper.Success(NutritionDetails()))
        }

    }

    @Test
    fun `click analysis with text and no Connection return no connection msg`() {
        val text ="1 cup rice"
        val list= mutableListOf(text)
        val modelRequest=AnalysisModelRequest(list)
        runBlocking {
            val result=  viewModel.repo.analysisIngredients(modelRequest)
            assertThat(result).isEqualTo(ResultWrapper.Success(NutritionDetails()))
        }

    }
}
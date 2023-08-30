package com.curso.android.app.practica.compare_txt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.compare_txt.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    private lateinit var viewModel:MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel= MainViewModel()
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

// Chequea que no arranque en string vacío... Un error que me tomó tiempo corregir...
    @Test
    fun mainViewModel_checkInitialValue() = runTest{
        val value = viewModel.compareData.value?.result
        assertNotEquals("", value)
    }

// Chequea que funcione la actualización de resultados...
    @Test
    fun mainViewModel_testInput() = runTest {
        val state1 =  viewModel.compareData.value?.result
        launch {
            viewModel.updateResult("test!")
        }
        advanceUntilIdle()
        val state2= viewModel.compareData.value?.result
        assertNotEquals(state1,state2)
    }
}
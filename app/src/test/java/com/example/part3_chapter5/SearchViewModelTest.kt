package com.example.part3_chapter5

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.part3_chapter5.model.ImageItem
import com.example.part3_chapter5.model.ListItem
import com.example.part3_chapter5.model.VideoItem
import com.example.part3_chapter5.repository.SearchRepository
import io.reactivex.rxjava3.core.Observable
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var searchRepository: SearchRepository

    @Mock
    lateinit var mockLoadingObserve: Observer<Boolean>

    @Mock
    lateinit var mockListObserver: Observer<List<ListItem>>

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        viewModel = SearchViewModel(searchRepository)
        viewModel.showLoading.observeForever(mockLoadingObserve)
        viewModel.listLiveData.observeForever(mockListObserver)
    }

    @Test
    fun searchNotEmpty() {
        Mockito.`when`(searchRepository.search(Mockito.anyString())).thenReturn(Observable.just(mockList()))
        viewModel.search("query")

        Mockito.verify(mockLoadingObserve, Mockito.times(1)).onChanged(true)
        Mockito.verify(mockListObserver, Mockito.times(1)).onChanged(Mockito.anyList())
        assertTrue(!viewModel.listLiveData.value.isNullOrEmpty())
    }

    @Test
    fun searchEmpty() {
        Mockito.`when`(searchRepository.search(Mockito.anyString())).thenReturn(Observable.just(
            emptyList()
        ))
        viewModel.search("query")

        Mockito.verify(mockLoadingObserve, Mockito.times(1)).onChanged(true)
        Mockito.verify(mockListObserver, Mockito.times(1)).onChanged(Mockito.anyList())
        assertTrue(viewModel.listLiveData.value.isNullOrEmpty())
    }

    private fun mockList() = listOf(
        ImageItem("thumbnailUrl", "collection", "siteName", "docUrl", Date(), false),
        ImageItem("thumbnailUrl", "collection", "siteName", "docUrl", Date(), true),
        VideoItem("thumbnailUrl", "title", 3, "author", Date(), false)
    )


}
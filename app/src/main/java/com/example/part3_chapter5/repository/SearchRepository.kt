package com.example.part3_chapter5.repository


import com.example.part3_chapter5.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {

    fun search(query: String): Observable<List<ListItem>>
}
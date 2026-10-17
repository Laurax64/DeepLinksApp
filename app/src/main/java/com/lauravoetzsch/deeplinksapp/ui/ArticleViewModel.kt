package com.lauravoetzsch.deeplinksapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lauravoetzsch.deeplinksapp.data.Article
import com.lauravoetzsch.deeplinksapp.data.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    // articles and selected articles could be used as one UIState stream
    // which will scale better when exposing more data.
    // Since there are only these two, it is okay to expose them as separate streams
    val articles: List<Article> = articleRepository.article
    private val _selectedArticle = MutableStateFlow<Article?>(value = null)
    val selectedArticle: StateFlow<Article?>
        get() = _selectedArticle

    // Method to update the current article selection
    fun updateSelectedArticleByName(name: String) {
        viewModelScope.launch {
            val selectedArticle: Article? = articleRepository.getArticleByName(name)
            if (selectedArticle != null) {
                _selectedArticle.value = selectedArticle
            }
        }
    }
}
package com.example.firebase.ui.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebase.model.Mahasiswa
import com.example.firebase.repository.RepositoryMhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repoMhs: RepositoryMhs
) : ViewModel() {

    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs() {
        viewModelScope.launch {
            repoMhs.getAllMhs().onStart {
                mhsUiState = HomeUiState.Loading
            }
                .catch { e ->
                    mhsUiState = HomeUiState.Error(e = e)
                }
                .collect { mhsList ->
                    mhsUiState = if (mhsList.isEmpty()) {
                        HomeUiState.Error(Exception("Belum ada data mahasiswa"))
                    } else {
                        HomeUiState.Success(mhsList)
                    }
                }
        }
    }

    fun deleteMhs(mahasiswa: Mahasiswa) {
        viewModelScope.launch {
            try {
                repoMhs.deleteMhs(mahasiswa)
            } catch (e: Exception) {
                mhsUiState = HomeUiState.Error(e)
            }
        }
    }

    sealed class HomeUiState {
        object Loading : HomeUiState()
        data class Success(val data: List<Mahasiswa>) : HomeUiState()
        data class Error(val e: Throwable) : HomeUiState()
    }
}
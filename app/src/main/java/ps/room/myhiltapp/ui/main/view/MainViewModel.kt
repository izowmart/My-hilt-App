package ps.room.myhiltapp.ui.main.view

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ps.room.myhiltapp.model.User
import ps.room.myhiltapp.repository.MainRepository
import ps.room.myhiltapp.utils.NetworkHelper
import ps.room.myhiltapp.utils.Resource


class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper,
    @Assisted private var savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}

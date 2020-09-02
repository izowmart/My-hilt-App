package ps.room.myhiltapp.api

import ps.room.myhiltapp.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): Response<List<User>>{
        return apiService.getUsers()
    }
}
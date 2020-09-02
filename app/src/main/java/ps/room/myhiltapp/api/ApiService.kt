package ps.room.myhiltapp.api

import ps.room.myhiltapp.model.User
import ps.room.myhiltapp.utils.Resource
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}
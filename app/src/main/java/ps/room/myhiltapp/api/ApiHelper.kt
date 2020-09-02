package ps.room.myhiltapp.api

import ps.room.myhiltapp.model.User
import retrofit2.Response

interface ApiHelper{
    suspend fun getUsers(): Response<List<User>>
}
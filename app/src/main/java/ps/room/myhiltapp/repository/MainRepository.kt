package ps.room.myhiltapp.repository

import ps.room.myhiltapp.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}
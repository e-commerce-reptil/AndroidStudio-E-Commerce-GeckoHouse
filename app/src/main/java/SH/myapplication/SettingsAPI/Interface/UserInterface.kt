package SH.myapplication.SettingsAPI.Interface

import SH.myapplication.DataClass.UserInfo
import SH.myapplication.SettingsAPI.ResponseDataClass.SuccessResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInterface{
    @POST("user/login") //email, password
    fun userLogin(@Body userInfo : UserInfo) : Call<UserInfo>

    @POST("user/regis") //name, email, password, password_confirmation
    fun userRegis(@Body userInfo: UserInfo) : Call<SuccessResponse>
}
//package SH.myapplication.DataClass
//
//import SH.myapplication.All.emptyString
//import com.google.gson.annotations.SerializedName
//
//
//data class UserInfo(
//    @SerializedName("name") val userName: String?,
//    @SerializedName("email") val userEmail: String?,
//    @SerializedName("password") val userPassword: String?,
//    @SerializedName("password_confirmation") val userPasswordConfirmation: String?,
//    @SerializedName("api_token") val userAPItoken: String?
//){
//    constructor(userEmail: String?, userPassword: String?) :
//        this(emptyString, userEmail, userPassword, emptyString, emptyString)
//
//    constructor(userName: String?, userEmail: String?, userPassword: String?, userPasswordConfirmation: String?) :
//        this(userName, userEmail, userPassword, userPasswordConfirmation, emptyString)
//}
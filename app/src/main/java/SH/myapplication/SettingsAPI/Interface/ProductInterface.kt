//package SH.myapplication.SettingsAPI.Interface
//
//import SH.myapplication.SettingsAPI.ResponseDataClass.SuccessResponse
//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//import retrofit2.http.Query
//
//interface ProductInterface {
//    @GET("products")
//    fun allProducts(@Query("by") by:String?,
//                    @Query("merchandise") merchandiseID:Int?,
//                    @Query("group") groupID:Int?,
//                    @Query("search") searchKey:String?) : Call<SuccessResponse>
//
//    @GET("product={productID}")
//    fun eachProduct(@Path("productID") productID:Int?) : Call<SuccessResponse>
//}
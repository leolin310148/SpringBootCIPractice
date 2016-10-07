package me.leolin

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by leo on 2016/10/8.
 */
interface HelloApi {
    @GET("/api/hello") fun hello(): Call<HelloRes>
}

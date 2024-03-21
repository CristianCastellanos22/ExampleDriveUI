package com.cristian.castellanos.exampledriveui.di

import com.cristian.castellanos.exampledriveui.data.model.Component
import com.cristian.castellanos.exampledriveui.data.model.Label
import com.cristian.castellanos.exampledriveui.data.model.Page
import com.cristian.castellanos.exampledriveui.data.model.TextField
import com.cristian.castellanos.exampledriveui.data.model.TypeComponent
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private const val BASE_URL = "https://run.mocky.io/"
    val moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(Component::class.java, "type")
                .withSubtype(Label::class.java, TypeComponent.LABEL.name)
                .withSubtype(TextField::class.java, TypeComponent.TEXT_FIELD.name)
        )
        .build()

    val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    //@GET("api/path/{id}")
    @GET("v3/b2bbf6ba-85a9-483e-8acd-9363abc8632a")
    //fun getPage(@Path("id") id: String): Response<Page>
    suspend fun getPage(): Response<Page>
}

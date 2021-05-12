package com.fjbg.periodictable.di

import com.fjbg.periodictable.data.remote.endpoint.ElementApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {
	
	@Provides
	fun provideRetrofit(
		gson: Gson,
		okHttpClient: OkHttpClient
	): Retrofit {
		return Retrofit.Builder()
			.baseUrl("https://raw.githubusercontent.com/")
			.addConverterFactory(GsonConverterFactory.create(gson))
			.client(okHttpClient)
			.build()
	}
	
	@Provides
	fun elementsApi(retrofit: Retrofit): ElementApi = retrofit.create(ElementApi::class.java)
	
	@Provides
	fun provideGson(): Gson = GsonBuilder().setLenient().create()
	
	@Provides
	fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
		val loggin = HttpLoggingInterceptor()
		loggin.level = HttpLoggingInterceptor.Level.BODY
		return loggin
	}
	
	@Provides
	fun provideOkHttpClient(
		logging: HttpLoggingInterceptor,
	): OkHttpClient =
		OkHttpClient.Builder()
			.addNetworkInterceptor(logging)
			.build()
}
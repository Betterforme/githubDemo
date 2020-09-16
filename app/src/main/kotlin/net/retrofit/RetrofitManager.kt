package net.retrofit

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 *说明：网络配置
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class RetrofitManager private constructor() {
    companion object {
        private var retrofit: Retrofit? = null
            get() {
                if (field == null) {
                    field = create()
                }
                return field
            }

        fun get(): Retrofit {
            return retrofit ?: create()
        }

        private fun create() = Retrofit.Builder()
            .baseUrl(NetConfig.HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

}
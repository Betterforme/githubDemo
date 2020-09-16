package net.okhttp

import okhttp3.OkHttpClient

/**
 *
 *说明：暂不配置
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class OkHttpClient private constructor(){
    companion object {
        private var retrofit: OkHttpClient? = null
            get() {
                if (field == null) {
                    field = OkHttpClient().newBuilder().build()
                }
                return field
            }
    }

}
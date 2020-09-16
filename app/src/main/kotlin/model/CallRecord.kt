package github.demo.client.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.retrofit.NetConfig.HOST

/**
 *
 *说明：返回数据封装
 *@since: 2020-09-16
 *@author: shijie
 *
 */
@Keep
@Entity(tableName = "tab_api_call")
class CallRecord {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    /**
     * request timestamp
     */
    var requestTimeStamp: Long = 0

    /**
     * request url
     */
    var requestHost: String = HOST

    /**
     * requst  result
     */
    var requestResult: Boolean = false

}


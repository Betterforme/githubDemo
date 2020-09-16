package github.demo.client.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import github.demo.client.R
import github.demo.client.model.CallRecord
import model.GitHubData
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 *说明：
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class RecordAdapter(private val context: Context, val data: MutableList<CallRecord>) :
    RecyclerView.Adapter<RecordViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHold {
        return RecordViewHold(
            LayoutInflater.from(context).inflate(R.layout.item_call_record, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecordViewHold, position: Int) {
        holder.setView(data[position],position)
    }

}

class RecordViewHold(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val callTimes = itemView.findViewById<TextView>(R.id.call_tv_pos)
    private val callTimestamp = itemView.findViewById<TextView>(R.id.call_tv_timestamp)
    private val callResult = itemView.findViewById<TextView>(R.id.call_tv_result)

    fun setView(data: CallRecord,position: Int) {
        callTimes.text = data.id.toString()
        callTimestamp.text = formatTimestamp(data.requestTimeStamp, "yyyy-MM-dd HH:mm:ss")

        if(position == 0){
            callTimes.setTextColor(Color.RED)
            callTimestamp.setTextColor(Color.RED)
            callResult.setTextColor(Color.RED)
        }else{
            callResult.setTextColor(Color.BLUE)
            callTimestamp.setTextColor(Color.BLUE)
            callResult.setTextColor(Color.BLUE)
        }

        callResult.text = if (data.requestResult) {
            "request success"
        } else {
            "request fail"
        }

    }

    private fun formatTimestamp(stamp: Long, format: String): String {
        val sdf = SimpleDateFormat(format)
        return sdf.format(stamp)
    }
}


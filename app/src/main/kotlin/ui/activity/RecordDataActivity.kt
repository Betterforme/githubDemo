package ui.activity

import android.widget.Toast
import base.BaseActivity
import github.demo.client.R
import github.demo.client.adapter.RecordAdapter
import github.demo.client.rxbus.RxBus
import kotlinx.android.synthetic.main.activity_call_record.*
import viewmodel.RecordDataViewModel

/**
 *
 *说明：
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class RecordDataActivity : BaseActivity<RecordDataViewModel>() {

    override fun getLayoutId() = R.layout.activity_call_record

    private lateinit var adapter: RecordAdapter

    override fun flowOfSetupData() {
        initRcv()
        initBus()
        initListener()
    }

    private fun initListener() {
        swipe_fl.setOnRefreshListener {
            viewModel.getNewRecord()?.subscribe {
                if (it.isNotEmpty()) {
                    adapter.data.addAll(0, it)
                    adapter.notifyDataSetChanged()
                }
                swipe_fl.isRefreshing = false
            }
        }
        back.setOnClickListener {
            finish()
        }
    }

    private fun initBus() {
        RxBus.get {
            Toast.makeText(this, "Request has send", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRcv() {
        viewModel.getRecord()?.subscribe {
            adapter = RecordAdapter(this, it.toMutableList())
            call_record_rcv.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.removeAll()
    }

}

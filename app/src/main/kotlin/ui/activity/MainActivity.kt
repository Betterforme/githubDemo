package ui.activity

import android.content.Intent
import android.widget.Toast
import base.BaseActivity
import github.demo.client.R
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import model.GitHubData
import viewmodel.MainViewModel

/**
 *
 *说明：app主页
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class MainActivity : BaseActivity<MainViewModel>() {

    var disposable: Disposable? = null

    override fun getLayoutId() = R.layout.activity_main

    override fun flowOfGetData() {
        disposable =
            getData().subscribe({
                response_tv_github.text = it.toString()

                viewModel.getGithubInfo()
                viewModel.saveDataToDatabase(true)
            }, {
                viewModel.saveDataToDatabase(false)
            })
    }

    override fun flowOfSetupData() {
        viewModel.getRecentGithubInfo()
            .subscribe { data ->
                when (data) {
                    is GitHubData -> response_tv_github.text = data.toString()
                }
            }
    }

    override fun flowOfInitUi() {
        record_tv.setOnClickListener {
            startActivity(Intent(this, RecordDataActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

    private fun getData() = viewModel.getGithubInfo()
}
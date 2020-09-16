package viewmodel

import base.BaseViewModel
import github.demo.client.database.CallRecordDatabase
import github.demo.client.model.CallRecord
import github.demo.client.net.repo.GitHubApiRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *
 *说明：
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class RecordDataViewModel : BaseViewModel() {
    var recentId: Int = 1

    private val databaseRepo by lazy {
        GitHubApiRepo(CallRecordDatabase.get().dao())
    }

    fun getRecord(): Observable<List<CallRecord>>? =
        Observable.fromCallable {
            val data = databaseRepo.queryCall()
            data.getOrNull(0)?.let {
                recentId = it.id
            }
            data
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

    fun getNewRecord(): Observable<List<CallRecord>>? =
        Observable.fromCallable {
            val data = databaseRepo.queryCalls(recentId)
            data.getOrNull(0)?.let {
                recentId = it.id
            }
            data
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}
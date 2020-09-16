package viewmodel

import base.BaseViewModel
import github.demo.client.database.CallRecordDatabase
import github.demo.client.model.CallRecord
import github.demo.client.net.repo.GitHubApiRepo
import github.demo.client.rxbus.RxBus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import model.GitHubData
import net.repo.GitHubRepo
import net.retrofit.NetConfig.HOST
import net.retrofit.RetrofitManager
import java.util.concurrent.TimeUnit

/**
 *
 *说明：
 *@since: 2020-09-16
 *@author: shijie
 *
 */
class MainViewModel : BaseViewModel() {

    private val databaseRepo by lazy {
        GitHubApiRepo(CallRecordDatabase.get().dao())
    }

    private val githubRepo by lazy {
        RetrofitManager.get().create(GitHubRepo::class.java)
    }

    fun getGithubInfo(): Flowable<GitHubData> =
        Flowable.interval(1, 5, TimeUnit.SECONDS)
            .flatMap {
                githubRepo.githubData()
            }.doOnNext {
                databaseRepo.insertApiResult(it)
                RxBus.send(it)
            }
            .retry()
            .onBackpressureDrop()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun saveDataToDatabase(isSuccess: Boolean) {
        Observable.fromCallable {
            databaseRepo.insertCall(CallRecord().apply {
                requestHost = HOST
                requestTimeStamp = System.currentTimeMillis()
                requestResult = isSuccess
            })
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    fun getRecentGithubInfo(): Observable<out Any?> =
        Observable.fromCallable {
            databaseRepo.queryRecentResult() ?: ""
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}
package net.repo

import io.reactivex.rxjava3.core.Flowable
import model.GitHubData
import retrofit2.http.GET

/**
 *
 *说明：
 *@since: 2020-09-16
 *@author: shijie
 *
 */
interface GitHubRepo {
    @GET("/")
    fun githubData(): Flowable<GitHubData>
}
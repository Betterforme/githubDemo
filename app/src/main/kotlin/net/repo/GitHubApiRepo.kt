package github.demo.client.net.repo

import github.demo.client.database.RecordDao
import github.demo.client.model.CallRecord
import model.GitHubData

class GitHubApiRepo(private val recordDao: RecordDao) {

    fun insertCall(call: CallRecord) = recordDao.insertCall(call)
    fun insertApiResult(result: GitHubData) = recordDao.insertApiResult(result)

    fun queryRecentResult() = recordDao.queryRecentResult()
    fun queryCall() = recordDao.queryCall()
    fun queryCalls(recentId: Int) = recordDao.queryCalls(recentId)

}
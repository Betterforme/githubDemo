package github.demo.client.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import github.demo.client.model.CallRecord
import model.GitHubData

@Dao
interface RecordDao {
    @Query("SELECT * FROM tab_github_call_record ORDER BY id DESC LIMIT 1")
    fun queryRecentResult(): GitHubData?

    @Query("SELECT * FROM tab_api_call ORDER BY id DESC")
    fun queryCall(): List<CallRecord>

    @Query("SELECT * FROM tab_api_call WHERE id > :lastId ORDER BY id DESC")
    fun queryCalls(lastId: Int): List<CallRecord>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCall(call: CallRecord)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertApiResult(result: GitHubData)
}
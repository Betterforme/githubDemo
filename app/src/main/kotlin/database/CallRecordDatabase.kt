package github.demo.client.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import github.demo.client.appContext
import github.demo.client.model.CallRecord
import model.GitHubData
/**
 *
 *说明：viewModel基类
 *@since: 2020-09-16
 *@author: shijie
 *
 */
@Database(entities = [CallRecord::class, GitHubData::class], version = 1, exportSchema = false)
abstract class CallRecordDatabase : RoomDatabase() {

    abstract fun dao(): RecordDao

    companion object {
        private var dataBase: CallRecordDatabase? = null
            get() {
                if (field == null) {
                    field = create()
                }
                return field
            }

        fun get(): CallRecordDatabase {
            return dataBase ?: create()
        }

        private fun create() =
            Room.databaseBuilder(appContext, CallRecordDatabase::class.java, "record").build()
    }
}
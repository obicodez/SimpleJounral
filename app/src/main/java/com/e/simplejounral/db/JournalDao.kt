package com.e.simplejounral.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.simplejounral.data.Journal
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal_table ORDER BY id ASC")
    fun getJournal(): Flow<List<Journal>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(journal: Journal)

    @Query("DELETE FROM journal_table")
    suspend fun deleteAll()
}
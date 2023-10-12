//package com.example.android.marsphotos.data.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.android.marsphotos.data.db.entities.User
//import com.example.android.marsphotos.data.db.entities.UserDAO
//
//
//@Database(entities = arrayOf(User::class), version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDAO
//
//    companion object {
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(
//            context: Context
//        ): AppDatabase = instance ?: synchronized(this) {
//            instance ?: buildDatabase(context).also { instance = it }
//        }
//
//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(
//                context,
//                AppDatabase::class.java,
//                "MyTv_database"
//            ).build()
//        }
//    }
//}
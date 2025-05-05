package com.jurado.finalproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun favoriteCityDao(): FavoriteCityDao

    companion object {
        @Volatile private var INSTANCE: WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

package com.masai.loginauthapp.room

import androidx.room.*
import kotlinx.coroutines.selects.select

@Dao
interface LoginDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun register(loginEntity: LoginEntity)

    @Query( "select * from login_table where email = :email and password = :password")
    fun getUser(email: String, password: String) : LoginEntity

    @Update
    fun updateUser(loginEntity: LoginEntity)

    @Delete
    fun deleteUser(loginEntity: LoginEntity)

}
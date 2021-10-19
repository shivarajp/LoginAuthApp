package com.masai.loginauthapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_table")
data class LoginEntity(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "age") var age:Int,
    @ColumnInfo(name = "mobile") var mobile: Int,
    @ColumnInfo(name = "password") var password: String
){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0
}
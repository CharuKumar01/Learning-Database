package com.example.database.datastore

import androidx.datastore.core.Serializer
import com.example.database.UserPreferences
import java.io.InputStream
import java.io.OutputStream

object UserPrefSerializer : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferences {
        return UserPreferences.parseFrom(input)
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        t.writeTo(output)
    }
}
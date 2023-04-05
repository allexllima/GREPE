package com.softgus.grepe.config

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class MySQLConnector {
    private val url = "jdbc:mysql://10.81.28.18:3306/test"
    private val user = "asdf"
    private val password = "asdf"

    fun getConnection(): Connection? {
        var connection: Connection? = null
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            connection = DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
            println("SQLException: " + e.message)
            println("SQLState: " + e.getSQLState())
            println("VendorError: " + e.getErrorCode())
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            println("Config.Conn-InstantiotionException/IllegalAccessException: " + e)
        }
        return connection
    }
}
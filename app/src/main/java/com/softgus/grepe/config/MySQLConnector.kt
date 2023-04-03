package com.softgus.grepe.config

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class MySQLConnector {
    private val url = "jdbc:mysql://HostNAME:3306/grepe?zeroDateTimeBehavior=convertToNull"
    private val user = "user"
    private val password = "Password"

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
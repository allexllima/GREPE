package com.softgus.grepe.dao

import com.softgus.grepe.config.ConnMySQL
import com.softgus.grepe.config.MySQLConnector
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class Person {
    private lateinit var conn: Connection
    private lateinit var stm: Statement

    private lateinit var id: String
    private lateinit var name: String

    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }

    fun getId(): String {
        return id
    }

    fun getName(): String {
        return name
    }

    /*@Throws(SQLException::class, ClassNotFoundException::class)
    constructor() {
        ConnMySQL.initConnection()
        conn = ConnMySQL.getConnection()
        stm = conn.createStatement()
    }

    @Throws(SQLException::class)
    fun closeConnection() {
        stm!!.close()
    }*/

    fun getUsers(): List<Person> {
        val connection = MySQLConnector().getConnection()
        val query = "SELECT * FROM user"
        val resultSet = connection?.createStatement()?.executeQuery(query)
        println(resultSet)
        val users = mutableListOf<Person>()
        while (resultSet?.next() == true) {
            val id = resultSet.getString("matricula")
            val name = resultSet.getString("nome")
            val usuario = Person(id, name)
            users.add(usuario)
        }
        connection?.close()
        //println("Usuários: ${users.get(0).toString()} - ${users.get(1).toString()}")
        return users
    }

    fun queryPerson(valor: String): ArrayList<Any>? {
        val rs: ResultSet
        val registroLido = ArrayList<Any>()
        try {
            rs = stm!!.executeQuery(
                "SELECT * FROM funcionarios " +
                        "WHERE matricula=\"" + valor + "\""
            )
            while (rs.next()) {
                registroLido.add(rs.getString("matricula"))
                registroLido.add(rs.getString("nome"))
                registroLido.add(rs.getString("departamento"))
                registroLido.add(rs.getString("funcao"))
            }
            //this.stm.close();
        } catch (ex: SQLException) {
            println("BDFuncionarios.consultar(): $ex")
        }
        return registroLido
    }

}
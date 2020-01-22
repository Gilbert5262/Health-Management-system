/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author HP
 */
public class DatabaseConnection {
Connection conn;
Statement stmt;
ResultSet res; 

public DatabaseConnection(){
 
}
 
public Connection setConnection(){
try{
    System.out.println("sdsadasd");
Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rhc","root","");
 System.out.println("Connected to the database");
}catch(Exception e){
 
}
return conn;
}
 
public ResultSet getResult(String sql,Connection conn){
this.conn=conn;
try{
stmt=conn.createStatement();
res=stmt.executeQuery(sql);
}catch(Exception e){
 
}
return res;
}
}

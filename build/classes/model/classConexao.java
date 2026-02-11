/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 
public class classConexao {
     public Connection conectar(){
         try{
             return DriverManager.getConnection("jdbc:mysql://localhost/bdmtcc","root","");
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Erro De conexao");
              return null;
          }
     }
     }

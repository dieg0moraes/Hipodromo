/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnoFI
 */
public class BaseDatos {
    
    private static BaseDatos instancia = new BaseDatos();
    private Connection conexion;
    private Statement stmt;

    public static BaseDatos getInstancia() {
        return instancia;
    }
    
    private BaseDatos() {
    }
    
    public void conectar (String driver,String url,String usr,String pwd){
        try {
            if(conexion==null){
                Class.forName(driver); //"carga la clase del driver"
                conexion = DriverManager.getConnection(url, usr, pwd);
                stmt = conexion.createStatement();
                System.out.println("CONECTADO!");
            }else{
                System.out.println("YA ESTAS CONECTADO");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de conexion:" + ex.getMessage());
            //System.out.println("Codigo de error:" + ex.getErrorCode());
        }
    }
    
    public void desconectar(){
        if(conexion!=null){
            try {
                conexion.close();
                conexion = null;
                System.out.println("DESCONECTADO");
            } catch (SQLException ex) {
           
            }
        }
    }
    
    public ResultSet consultar(String sql){
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar consulta:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return null;
        }
    }
    
    //INSERT; DELETE; UPDATE
    public int modificar(String sql){
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al modificar la base:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return -1;
        }
    }
    
    public synchronized boolean transaccion(ArrayList<String> comandos){
        boolean resultado = false;
        try {
            conexion.setAutoCommit(false); //BEGIN T
            for(String c:comandos){
                if(modificar(c)==-1){ //Error
                    conexion.rollback();
                    System.out.println("ROLLBACK!");
                    return false;
                }
            }
            conexion.commit();
            resultado = true;
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar TRANSACCION: " + ex.getMessage());
        }finally{
            try {
                //Siempre dejo igual el auto commit
                conexion.setAutoCommit(true);
                
            } catch (SQLException ex) {
                System.out.println("Error al re establecer auto comit");
                conexion = null;
            }
        }
        
        return resultado;
    }

    
    
    
}

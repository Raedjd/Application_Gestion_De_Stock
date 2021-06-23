/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.Socket;
import java.sql.*;

/**
 *
 * @Raed Jaidi
 */
public class Base_de_donnee {
    
    Connection cnx;
    Statement stat;
    String SQL;
    String url;
    String username;
    String password;
    Socket client;
    int Port;
    String Host;

    public Base_de_donnee(String url, String username, String password, int Port, String Host) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.Port = Port;
        this.Host = Host;
    }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
    public Base_de_donnee(String HOST_BD, String USER_NAME_BD, String PASSWORD_BD, String IP_HOST, int PORT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
    public Connection  cnxDataBase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection(url, SQL, password);
            
             }catch (Exception x) 
             {System.err.println(x.getMessage());} 
        return cnx;
    }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////    
    public Connection  closecnx(){
        try {
         
            cnx.close();
            
             }catch (Exception x) 
             {System.err.println(x);} 
        return cnx;
    } 
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
    public ResultSet executionQuery(String sql){
       cnxDataBase();
       ResultSet res=null;
       
        try {
             stat=cnx.createStatement();
             res= stat.executeQuery(sql);
             System.err.println(sql);
             }catch (SQLException x) 
             {System.err.println(x);} 
        return res;      
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
   public String executionUpdate(String sql){
       cnxDataBase();
      String  res="";
       
        try {
             stat=cnx.createStatement();
              stat.executeUpdate(sql);
             res=sql;
             }catch (SQLException x) 
             {res=x.toString();} 
        return res;      
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
   public ResultSet querySelectAll(String nameTable){
       cnxDataBase();
       
       SQL= "SELECT * FROM  " + nameTable;
       System.out.println(SQL);
       return this.executionQuery(SQL);
   }
     public ResultSet querySelectAll(String nameTable,String condition){
       cnxDataBase();
       
       SQL= "SELECT * FROM  " + nameTable + " WHERE" +condition;
       System.out.println(SQL);
       return this.executionQuery(SQL);
   }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
    public ResultSet querySelect(String nameTable,String[] nameColonne ){
         cnxDataBase();
         int i;
         SQL="SELECT" ;
         for(i=0; i<=nameColonne.length-1;i++) {
             
             SQL+=nameColonne[i];
             if(i<nameColonne.length-1)  SQL+=" , " ;
         }
         SQL+="FROM" +nameTable;
          return this.executionQuery(SQL);
    }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
       public ResultSet Selectcmd(String nameTable,String[] nameColonne,String condition ){
         cnxDataBase();
         int i;
         SQL="SELECT" ;
         for(i=0; i<=nameColonne.length-1;i++) {
             
             SQL+=nameColonne[i];
             if(i<nameColonne.length-1)  SQL+=" , " ;
         }
         SQL+="FROM" +nameTable + "WHERE" + condition;
          return this.executionQuery(SQL);
         }
       
 /////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////      
        public String queryInsert(String nameTable,String[] valeur ){
         cnxDataBase();
         int i;
         SQL="INSERT INTO" + nameTable + "VALUES(" ;
         for(i=0; i<= valeur.length-1;i++) {
             
             SQL+=" ' " +valeur[i] + " ' ";
             if(i<valeur.length-1)  SQL+=" , " ;
         }
         SQL+=")" ;
          return this.executionUpdate(SQL);
    }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
        public String queryInsert(String nameTable,String[] valeur,String[] nameColonne ){
         cnxDataBase();
         int i;
         SQL="INSERT INTO" + nameTable + "(" ;
         for(i=0; i<= nameColonne.length-1;i++) {
             
              SQL+=nameColonne[i];
             if(i<nameColonne.length-1)  SQL+=" , " ;
         }
         SQL+=") VALUES(" ;
         
          for(i=0; i<= valeur.length-1;i++) {
             
             SQL+=" ' " +valeur[i] + " ' ";
             if(i<valeur.length-1)  SQL+=" , " ;
         }
           SQL+=")" ;
          return this.executionUpdate(SQL);
    }   
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////

public String queryUpdate(String nameTable,String[] nameColonne,String[] valeur,String condition){
          cnxDataBase();
         int i;
         SQL=" UPDATE " + nameTable + " SET " ; 
          for(i=0; i<= nameColonne.length-1;i++) {
             
              SQL+=nameColonne[i] + "='" + valeur[i] + "'";
             if(i<nameColonne.length-1)  SQL+=" , " ;
         }
          SQL+= "WHERE" + valeur;
            return this.executionUpdate(SQL);
}     
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////

public String queryDelete(String nameTable){
    cnxDataBase();
    SQL+="DELETE FROM" + nameTable;
    return this.executionUpdate(SQL);
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////

public String queryDelete(String nameTable,String condition){
    cnxDataBase();
    SQL+="DELETE FROM" + nameTable + "WHERE" + condition;
    return this.executionUpdate(SQL);
}
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.sql.*;
import javax.swing.table.AbstractTableMode1;

/**
 *
 * @Raed Jaidi
 */
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
public class Table1 extends AbstractTableMode1 {

private ResultSet res;

    public Table1(ResultSet res) {
        this.res = res;
    }
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////    
public int getColumnCount()    {
    try {
        if(res==null)
            return 0;
         else
            return res.getMetaData().getColumnCount();
        
        }catch (SQLException e) 
        {   System.out.print("Error");
            System.out.print(e.getMessage());}
    return 0;
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////
public int getRowCount()    {
    try {
        if(res==null)
            return 0;
         else
            res.last();
            return res.getRow();
        
        }catch (SQLException e) 
        {   System.out.print("Error");
         System.out.print(e.getMessage());}
    return 0;
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////

public Object getValueAt(int rowIndex,int colmunIndex){
    
    if(rowIndex < 0 || rowIndex > getRowCount() || colmunIndex < 0 || colmunIndex > getColumnCount() )
        return null;
     try {
        if(res==null)
            return null;
         else
            res.absolute(rowIndex + 1);
            return res.getObject(colmunIndex + 1);
        
        }catch (SQLException e) 
        {   System.out.print("Error wwhile fetching rows");
         System.out.print(e.getMessage());}
     return null;
}
/////////////////////////////////////////////Raed Jaidi///////////////////////////////////////////////////

@Override
public String  getColmunName(int colmunIndex) {
    
    try { 
          return res.getMetaData().getColumnName(colmunIndex + 1);
       }catch (SQLException e) 
        {   System.out.print("Error wwhile fetching column Name");
         System.out.print(e.getMessage());}
         return super.getColmunName(colmunIndex);
}
}

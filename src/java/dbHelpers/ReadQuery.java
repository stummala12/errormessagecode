
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Family;

public class ReadQuery {
   
   private Connection conn;
   private ResultSet results;
   
   public ReadQuery () {
       
       Properties props = new Properties(); //mwc
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
       try {
           props.load(instr);
       } catch (IOException ex) {
           Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           instr.close();
       } catch (IOException ex) {
           Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
       try {
           Class.forName(driver);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           conn = DriverManager.getConnection(url, username, passwd);
       } catch (SQLException ex) {
           Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   
   public void doRead(){
       
       try {
           String query = "Select * from family";
           
           PreparedStatement ps = conn.prepareStatement(query);
           this.results = ps.executeQuery();
       } catch (SQLException ex) {
           Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
      
   }
   
   
   public String getHTMLtable(){
       
       String table = "";
       
       table += "<table border=1>";
       
       try {
           while(this.results.next()){
               
               Family family = new Family();
               family.setMemberID(this.results.getInt("memberID"));
               family.setMemberName(this.results.getString("memberName"));
               family.setEmailAddr(this.results.getString("emailAddr"));
               family.setAge(this.results.getInt("age"));
               family.setFavoriteColor(this.results.getString("favoriteColor"));
               
               table += "<tr>";
               table += "<td>";
               table += family.getMemberID();
               table += "</td>";
               table += "<td>";
               table += family.getMemberName();
               table += "</td>";
               table += "<td>";
               table += family.getEmailAddr();
               table += "</td>";
               table += "<td>";
               table += family.getAge();
               table += "</td>";
               table += "<td>";
               table += family.getFavoriteColor();
               table += "</td>";
               
               table += "</tr>";
           }   } catch (SQLException ex) {
           Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       table += "</table>"; 
               
            return table;
     
   }

    

    public String getHTMLTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   


}

       
       
       
       
       
       
      
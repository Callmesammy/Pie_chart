
package Connectivity;

import java.sql.Connection;
import java.sql.SQLException;


public class dataConnection {

    /**
     * @return the connection
     */
  
   
    private Connection connection;
    
    
    
    
        private static dataConnection instance;
    
    public static dataConnection instance(){
        if (instance ==null) {
            instance = new dataConnection();
        }
        return instance;
    }
    
    public void tConnection() throws SQLException{
        String server = "localhost";
        String port = "3306";
        String database = "sql_store";
        String user = "root";
        String Password = "123";
        connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/"+ database,user,Password);
        
    }
        public void setConnection(Connection connection) {
        this.connection = connection;
    }
      public Connection getConnection() {
        return connection;
    }

       
  
        
}

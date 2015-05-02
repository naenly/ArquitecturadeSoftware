
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.CompraDao;
import edu.uan.fis.jeesample.dto.Compra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraDaoJdbc implements CompraDao{

    @Override
    public Compra create(Compra compra) {
         // Sample code
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            // 3. Creates the product in the database
            //stmt = conn.createStatement();
            //stmt.executeUpdate("INSERT INTO PRODUCTS VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
            stmt = conn.prepareStatement("INSERT INTO COMPRA (ID_COMPRA, NOMBRECLIENTE) VALUES ( ?, ?) ");
            stmt.setInt(1, compra.getIdcompra());
            stmt.setString(2, compra.getNombrecliente());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compra;
    }

    @Override
    public Compra update(Compra compra) {
         // Sample code
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            // 3. Creates the product in the database
            stmt = conn.prepareStatement("UPDATE COMPRA SET  NOMBRECLIENTE =?  WHERE ID_COMPRA= ?");  
            stmt.setString(1, compra.getNombrecliente());
            stmt.setInt(2, compra.getIdcompra());
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compra;
    }

    @Override
    public void delete(Compra compra) {
         // Sample code
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement stmt=null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            // 3. Creates the product in the database
            //stmt = conn.createStatement();
            //stmt.executeUpdate("DELETE FROM PRODUCTS WHERE ID_PRODUCT=" + product.getProductId());
            stmt= conn.prepareStatement("DELETE FROM COMPRA WHERE ID_COMPRA = ?");
            stmt.setInt(1, compra.getIdcompra());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Compra findById(Integer Idcompra) {
       Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Compra o= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            // 3. Creates the product in the database
            //stmt =conn.createStatement();
            //stmt.executeUpdate("SELECT * FROM  PRODUCTS WHERE ID_PRODUCT = " + productId.intValue());
            stmt = conn.prepareStatement("SELECT * FROM  COMPRA WHERE ID_COMPRA = ?");
            stmt.setInt(1, Idcompra);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            o = new Compra();
            o.setIdcompra(rs.getInt("ID_COMPRA"));
            o.setNombrecliente(rs.getString("NOMBRECLIENTE"));
                

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return o;
    }

    @Override
    public List<Compra> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Compra> o= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            // 3. Creates the product in the database
            
            stmt = conn.prepareStatement("SELECT * FROM  COMPRA");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            Compra p = new Compra();
            p.setIdcompra(rs.getInt("ID_COMPRA"));
            p.setNombrecliente(rs.getString("NOMBRECLIENTE"));
            o.add(p);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return  o;
    }
    
    
    
}

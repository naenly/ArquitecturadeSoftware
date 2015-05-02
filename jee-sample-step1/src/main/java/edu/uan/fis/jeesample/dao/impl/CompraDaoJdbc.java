
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.CompraDao;
import edu.uan.fis.jeesample.dto.Compra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra findById(Integer Idcompra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compra> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

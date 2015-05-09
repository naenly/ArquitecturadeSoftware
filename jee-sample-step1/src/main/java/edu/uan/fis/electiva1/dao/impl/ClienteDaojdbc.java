package edu.uan.fis.electiva1.dao.impl;

import edu.uan.fis.electiva.dao.ClienteDao;
import edu.uan.fis.electiva1.dto.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDaojdbc implements ClienteDao {

    @Override
    public Cliente create(Cliente cliente) {
         
        Connection conn = null;
        
        PreparedStatement stmt = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt = conn.prepareStatement("INSERT INTO CLIENTE (USUARIO, CONTRASEÑA) VALUES ( ?, ? ) ");
            stmt.setString(1,cliente.getUsuario());
            stmt.setString(2, cliente.getConstraseña());
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
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
      
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt = conn.prepareStatement("UPDATE CLIENTE SET  CONTRASEÑA=?  WHERE USUARIO= ?");  
            stmt.setString(1,cliente.getConstraseña());
            stmt.setString(2,cliente.getUsuario());
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
        return cliente;
    }

    @Override
    public void delete(Cliente cliente) {
       
        Connection conn = null;
       
        PreparedStatement stmt=null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt= conn.prepareStatement("DELETE FROM CLIENTE WHERE USUARIO = ?");
            stmt.setString(1, cliente.getUsuario());
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
    public Cliente findByUsuario(String usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Cliente c= null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt = conn.prepareStatement("SELECT * FROM  CLIENTE WHERE USUARIO = ?");
            stmt.setString(1, usuario);
            stmt.executeUpdate();    
            rs = stmt.executeQuery();
            while(rs.next()){
            c = new Cliente();
            c.setConstraseña(rs.getString("CONTRASEÑA"));
            c.setUsuario(rs.getString("USUARIO"));
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
        return c;
    }

    @Override
    public List<Cliente> findAllUsuario() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Cliente> c= null;
        try {
          
            Class.forName("com.mysql.jdbc.Driver");
          
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt = conn.prepareStatement("SELECT * FROM  CLIENTE");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            Cliente ce = new Cliente();
            ce.setUsuario(rs.getString("USUARIO"));
            ce.setConstraseña(rs.getString("CONTRASEÑA"));
            c.add(ce);
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
        return  c;
    
    }
    
  
}


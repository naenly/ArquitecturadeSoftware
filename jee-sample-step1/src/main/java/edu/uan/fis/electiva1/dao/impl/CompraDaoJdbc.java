
package edu.uan.fis.electiva1.dao.impl;

import edu.uan.fis.electiva.dao.CompraDao;
import edu.uan.fis.electiva1.dto.Compra;
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
      
        Connection conn = null;
   
        PreparedStatement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");     
            stmt = conn.prepareStatement("INSERT INTO COMPRA (ID_PRODUCT, USUARIO) VALUES ( ?, ?) ");
            stmt.setInt(1, compra.getIdproducto());
            stmt.setString(2, compra.getUsuario());
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
       
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt = conn.prepareStatement("UPDATE COMPRA SET  ID_PRODUCT =?  WHERE USUARIO= ?");  
            stmt.setInt(1, compra.getIdproducto());
            stmt.setString(2, compra.getUsuario());
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
        
        Connection conn = null;
        
        PreparedStatement stmt=null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt= conn.prepareStatement("DELETE FROM COMPRA WHERE USUARIO = ?");
            stmt.setString(1, compra.getUsuario());
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
    public Compra findByUsuario(String Usuario) {
       Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Compra o= null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt = conn.prepareStatement("SELECT * FROM  COMPRA WHERE USUARIO = ?");
            stmt.setString(1, Usuario);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            o = new Compra();
            o.setIdproducto(rs.getInt("ID_PRODUCT"));
            o.setUsuario(rs.getString("USUARIO"));
                

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
    public List<Compra> findAllCompra() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Compra> o= null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
          
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            
            stmt = conn.prepareStatement("SELECT * FROM  COMPRA");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            Compra p = new Compra();
            p.setIdproducto(rs.getInt("ID_PRODUCT"));
            p.setUsuario(rs.getString("USUARIO"));
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

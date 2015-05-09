package edu.uan.fis.electiva1.dao.impl;


import edu.uan.fis.electiva.dao.OrdencompraDao;
import edu.uan.fis.electiva1.dto.Ordencompra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrdencompraDaoJdbc implements OrdencompraDao {

    @Override
    public Ordencompra create(Ordencompra orden) {
       
        Connection conn = null;
        
        PreparedStatement stmt = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt = conn.prepareStatement("INSERT INTO ORDENCOMPRA (ID_ORDEN, USUARIO) VALUES ( ?, ?) ");
            stmt.setInt(1, orden.getIdcompra());
            stmt.setString(2, orden.getUsuario());
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
        return orden;
    }

    @Override
    public Ordencompra update(Ordencompra orden) {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
          
            stmt = conn.prepareStatement("UPDATE ORDENCOMPRA SET  USUARIO =?  WHERE ID_ORDEN= ?");  
            stmt.setString(1, orden.getUsuario());
            stmt.setInt(2, orden.getIdcompra());
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
        return orden;
    }

    @Override
    public void delete(Ordencompra orden) {
        
        Connection conn = null;
        
        PreparedStatement stmt=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt= conn.prepareStatement("DELETE FROM ORDENCOMPRA WHERE ID_ORDEN = ?");
            stmt.setInt(1, orden.getIdcompra());
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
    public Ordencompra findById_Ordencompra(Integer IdOrden) {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Ordencompra o= null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
          
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt = conn.prepareStatement("SELECT * FROM  ORDENCOMPRA WHERE ID_ORDEN = ?");
            stmt.setInt(1, IdOrden);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            o = new Ordencompra();
            o.setIdorden(rs.getInt("ID_ORDEN"));
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
    public List<Ordencompra> findAllId_Ordencompra() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Ordencompra> o= null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            
            stmt = conn.prepareStatement("SELECT * FROM  ORDENCOMPRA");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            Ordencompra p = new Ordencompra();
            p.setIdorden(rs.getInt("ID_ORDEN"));
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


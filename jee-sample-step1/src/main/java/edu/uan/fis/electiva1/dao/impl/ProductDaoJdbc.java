package edu.uan.fis.electiva1.dao.impl;

import edu.uan.fis.electiva.dao.ProductDao;
//jhon alejandro leon sissa
/**
 * 
 */

import edu.uan.fis.electiva1.dto.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoJdbc implements ProductDao {
    
    public Product create(Product product) {
        
        Connection conn = null;
        
        PreparedStatement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt = conn.prepareStatement("INSERT INTO PRODUCTS (ID_PRODUCT, NOMBRE, PRECIO) VALUES ( ?, ?, ? ) ");
            stmt.setInt(1, product.getProductId());
            stmt.setString(2,product.getName());
            stmt.setInt(3, product.getPrecio());
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
        return product;
    }
    
    public Product update(Product product) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            stmt = conn.prepareStatement("UPDATE PRODUCTS SET  NOMBRE=?, PRECIO=?  WHERE ID_PRODUCT= ?");  
            stmt.setString(1,product.getName());
            stmt.setInt(2, product.getPrecio());
            stmt.setInt(3, product.getProductId());
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
        return product;
    }
    
    public void delete(Product product) {
         
        Connection conn = null;
        
        PreparedStatement stmt=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
            stmt= conn.prepareStatement("DELETE FROM PRODUCTS WHERE ID_PRODUCT = ?");
            stmt.setInt(1, product.getProductId());
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
    
    public Product findById(Integer productId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Product p= null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
           
           
           
            stmt = conn.prepareStatement("SELECT * FROM  PRODUCTS WHERE ID_PRODUCT = ?");
            stmt.setInt(1, productId);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            p = new Product();
            p.setName(rs.getString("NOMBRE")); 
            p.setPrecio(rs.getInt("PRECIO"));
                

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
        return p;
    }
 
    
    
    public List<Product> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<Product> l= null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "blackjals");
            
            
            stmt = conn.prepareStatement("SELECT * FROM  PRODUCTS");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            Product p = new Product();
            p.setName(rs.getString("NOMBRE"));
            p.setProductId(rs.getInt("ID_PRODUCT"));
            p.setPrecio(rs.getInt("PRECIO"));
            
            l.add(p);
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
        return  l;
    
}

}

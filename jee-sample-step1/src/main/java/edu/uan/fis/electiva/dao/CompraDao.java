//
package edu.uan.fis.electiva.dao;

import edu.uan.fis.electiva1.dto.Compra;
import java.util.List;

public interface CompraDao {
    Compra create(Compra compra);
    Compra  update(Compra  compra);
    void delete(Compra  compra);
    Compra  findByUsuario(String Usuario);
    List<Compra> findAllCompra();
    
}

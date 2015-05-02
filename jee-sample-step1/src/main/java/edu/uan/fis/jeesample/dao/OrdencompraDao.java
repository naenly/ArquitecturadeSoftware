
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Ordencompra;
import java.util.List;

public interface OrdencompraDao {
    Ordencompra create(Ordencompra cliente);
    Ordencompra  update(Ordencompra  cliente);
    void delete(Ordencompra  cliente);
    Ordencompra  findById(String contraseña);
    List<Ordencompra > findAll();
}

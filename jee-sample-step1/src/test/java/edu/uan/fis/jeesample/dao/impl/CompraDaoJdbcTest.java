package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Compra;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class CompraDaoJdbcTest extends TestCase {
    
    public CompraDaoJdbcTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        System.out.println("create");
        Compra compra = new Compra();
        compra.setIdcompra(1);
        compra.setNombrecliente("ALEJO07");
        
        CompraDaoJdbc instance = new CompraDaoJdbc();
        Compra expResult = compra;
        Compra result = instance.create(compra);
        assertEquals(expResult, result);
    }

//    public void testUpdate() {
//        System.out.println("update");
//        Ordencompra cliente = new Ordencompra("TERROR",2);
//        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
//        Ordencompra expResult = cliente;
//        Ordencompra result = instance.update(cliente);       
//        assertEquals(expResult, result);  
//
//    }
//
//    public void testDelete() {
//        System.out.println("delete");
//        Ordencompra orden = new Ordencompra(5);
//        orden.getIdcompra();
//        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
//        instance.delete(orden);    
//    }
//
//    public void testFindById() {
//        System.out.println("findById");
//        Integer IdOrden = 1;
//        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
//        Ordencompra expResult = null;
//        Ordencompra result = instance.findById(IdOrden);
//        assertEquals(expResult, result);
//        
//        
//    }
//
//    public void testFindAll() {
//        System.out.println("findAll");
//        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
//        List expResult = null;
//        List result = instance.findAll();
//        assertEquals(expResult, result);
//       
//    }
}


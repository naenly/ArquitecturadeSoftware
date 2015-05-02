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

    public void testUpdate() {
        System.out.println("update");
        Compra compra = new Compra("JESO09",3);
        CompraDaoJdbc instance = new CompraDaoJdbc();
        Compra expResult = compra;
        Compra result = instance.update(compra);       
        assertEquals(expResult, result);  

    }

    public void testDelete() {
        System.out.println("delete");
        Compra compra = new Compra(5);
        compra.getIdcompra();
        CompraDaoJdbc instance = new CompraDaoJdbc();
        instance.delete(compra);    
    }

    public void testFindById() {
        System.out.println("findById");
        Integer Idcompra = 1;
        CompraDaoJdbc instance = new CompraDaoJdbc();
        Compra expResult = null;
        Compra result = instance.findById(Idcompra);
        assertEquals(expResult, result);
        
        
    }

    public void testFindAll() {
        System.out.println("findAll");
        CompraDaoJdbc instance = new CompraDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
       
    }
}


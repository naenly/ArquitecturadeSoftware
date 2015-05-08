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
        compra.setIdproducto(2);
        compra.setUsuario("JALS");   
        CompraDaoJdbc instance = new CompraDaoJdbc();
        Compra expResult = compra;
        Compra result = instance.create(compra);
        assertEquals(expResult, result);
    }

    public void testUpdate() {
        System.out.println("update");
        Compra compra = new Compra(3, "Alejo007");
        CompraDaoJdbc instance = new CompraDaoJdbc();
        Compra expResult = compra;
        Compra result = instance.update(compra);       
        assertEquals(expResult, result);  

    }

    public void testDelete() {
        System.out.println("delete");
        Compra compra = new Compra("PIOLA34");
        compra.getUsuario();
        CompraDaoJdbc instance = new CompraDaoJdbc();
        instance.delete(compra);    
    }

    public void testFindById() {
        System.out.println("findById");
        String usuario = "JALS32";
        CompraDaoJdbc instance = new CompraDaoJdbc();
        Compra expResult = null;
        Compra result = instance.findByUsuario(usuario);
        assertEquals(expResult, result);
        
        
    }

    public void testFindAll() {
        System.out.println("findAll");
        CompraDaoJdbc instance = new CompraDaoJdbc();
        List expResult = null;
        List result = instance.findAllUsuario();
        assertEquals(expResult, result);
       
    }
}


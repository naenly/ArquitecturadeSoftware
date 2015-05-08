
package edu.uan.fis.jeesample.dto;

import java.io.Serializable;


public class Compra implements Serializable {
    private Integer Idcompra;
    private String nombrecliente;
    
 
public Compra(){}

public Compra(int Idcompra){
this.Idcompra=Idcompra;
}
    
public Integer getIdcompra(){
return Idcompra;
}    


 
public Compra(String nombre, int Idcompra){
this.Idcompra=Idcompra;
this.nombrecliente=nombre;
}

public void setIdcompra(Integer Idcompra){
this.Idcompra=Idcompra;
} 

public String getNombrecliente(){
return nombrecliente;
}

public void setNombrecliente(String nombre){
    this.nombrecliente=nombre;
}

}

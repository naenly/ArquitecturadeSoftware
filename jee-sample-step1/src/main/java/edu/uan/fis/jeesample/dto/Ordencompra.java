
package edu.uan.fis.jeesample.dto;

import java.io.Serializable;

public class Ordencompra implements Serializable {
    private Integer Idcompra;
    private String nombre;
    
public Integer getIdcompra(){
return Idcompra;
}    
 
public Ordencompra(){}

public Ordencompra(int IdOrden){
this.Idcompra=IdOrden;
}
public Ordencompra( String nombre, int Idcompra){
    this.Idcompra=Idcompra;
    this.nombre=nombre;
}

public void setIdcompra(Integer Idcompra){
this.Idcompra=Idcompra;
}

public String getNombre(){
return nombre;
}

public void setNombre(String nombre){
this.nombre=nombre;
}




}

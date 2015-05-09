
package edu.uan.fis.electiva1.dto;

import java.io.Serializable;


public class Compra implements Serializable {
    private Integer Idproducto;
    private String usuario;

 
public Compra(){}



public Compra(String Usuario){
this.usuario=Usuario;
}

 
public Compra( int Idproducto, String usuario){
this.Idproducto=Idproducto;
this.usuario=usuario;
}


public Integer getIdproducto(){
return Idproducto;
}    



public void setIdproducto(Integer Idcompra){
this.Idproducto=Idcompra;
} 

public String getUsuario(){
return usuario;
}

public void setUsuario(String usuario){
    this.usuario=usuario;
}

}

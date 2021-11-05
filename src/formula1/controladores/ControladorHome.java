/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;
import formula1.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 503
 */
public class ControladorHome implements ActionListener {
    
    //ATRIBUTOS
    VistaHome vistahome = new VistaHome();
    Escuderia escuderia= new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorHome(VistaHome vistahome,
            Escuderia escuderia,Piloto piloto) {
        
        this.escuderia=escuderia;
        this.piloto=piloto;
        this.vistahome=vistahome;
        vistahome.botonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ConsultasEscuderia consultasEscuderia= new ConsultasEscuderia();
        String id=vistahome.cajaIdEscuderia.getText();
        
        //SI consulta una escuderia y esta SI se encuentra
        if(consultasEscuderia.buscarEscuderia(id)!=null){
            
            //todo ok (retiro)
            
        }else{
            
            //Ingresar el piloto a la escuderia
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistahome.setVisible(false);
            vistaIngreso.setVisible(true);
            
        }
        
        
       
    }
    
    
    
    
}
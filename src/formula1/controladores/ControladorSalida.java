/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.ConsultasPilotos;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 503
 */
public class ControladorSalida implements ActionListener {
    
    //Atributos
    VistaSalida vistasalida = new VistaSalida();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorSalida(VistaSalida vistasalida, Escuderia escuderia,Piloto piloto) {
        
        this.vistasalida = vistasalida;
        this.escuderia = escuderia;
        this.piloto = piloto;
        vistasalida.botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         ConsultasEscuderia consultasEscuderia= 
                 new ConsultasEscuderia();
         
         ConsultasPilotos consultasPilotos = 
                 new ConsultasPilotos();
        
    }
    
    
    
    
    
}

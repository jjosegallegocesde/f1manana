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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

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
         
         //Consultar los datos del piloto a buscar para poder editarlo
         piloto=consultasPilotos.buscarPiloto(Integer.parseInt(vistasalida.cajaIdPiloto.getText()));
        
         //consultar la fecha entrada STRING
         String fechaEntrada=piloto.getFechaIn();
         
         //convertir la FECHA STRING EN DATE
         try{
             Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
             
             Date salida = new Date();
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String fechaSalida =formato.format(salida);
             
             //rutina para calcular la resta de tiempo
             long tiempoDiferencia=salida.getTime()-entrada.getTime();
             TimeUnit unidadTiempo=TimeUnit.MINUTES;
             long tiempoEnEscuderia=unidadTiempo.convert(tiempoDiferencia,TimeUnit.MILLISECONDS);
             
             //llevemos el valor de la fecha salida STRING al objeto piloto
             piloto.setFechaOut(fechaSalida);
             
             //ejecutar la consulta para actualizar el piloto
             if(consultasPilotos.actualizarPiloto(piloto)){
                  JOptionPane.showMessageDialog(null, "Exito retirando, se quedo: "+tiempoEnEscuderia);
             }else{
                 JOptionPane.showMessageDialog(null, "Fallamos retirando");
             }
                     
         }catch(ParseException error){
             System.out.println("upsss.. "+error);
         }
         
         
    }
    
    
    
    
    
}

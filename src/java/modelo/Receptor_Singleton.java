/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Bean.receta;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TITO
 */
public class Receptor_Singleton {
    private static Receptor_Singleton miSingleton;
    private Receptor_Singleton(){}
    public static Receptor_Singleton getReceptor_Singleton(){
        if(miSingleton == null){
            miSingleton = new Receptor_Singleton();
        }
        return miSingleton;
    }
    
    ArrayList <receta> lista = new ArrayList();
    private final static String QUEUE_NAME = "cola10";

    public ArrayList<receta> getMensajes() {
        return lista;
    }
    public void inicializarServicio(){
        
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                
                String [] contenido = message.split(",");
                
                receta nuevo = new receta();
                
                nuevo.setFecha(contenido[0]); 
                nuevo.setMed(contenido[1]); 
                nuevo.setNombre(contenido[2]); 
                nuevo.setApellido(contenido[3]); 
                nuevo.setDni(contenido[4]); 
                nuevo.setMedicamento(contenido[5]); 
                nuevo.setCantidad(contenido[6]); 
                nuevo.setIndicaciones(contenido[7]);
                
                lista.add(nuevo);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(Receptor_Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

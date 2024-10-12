/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author POWER
 */
public class Producto implements GestionReseña{

    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipo;
    private ArrayList<Reseña> reseñas = new ArrayList<>();


   
    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, String descripcion, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public void agregarReseña() {
   String descripcion = JOptionPane.showInputDialog("Redacta tu reseña :");
        int calificacion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué calificación le darías? (1-5)"
                + "\n[1] Pésima"
                + "\n[2] Mala"
                + "\n[3] Puede mejorar"
                + "\n[4] Buena"
                + "\n[5] Excelente"));
        Reseña reseña = new Reseña(descripcion, calificacion);
        reseñas.add(reseña);
        JOptionPane.showMessageDialog(null, "Reseña agregada con éxito."); 
    }

    @Override
    public ArrayList<Reseña> obtenerReseñas() {
      return reseñas;
    }
    
    
}

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
public class Producto implements GestionRese�a{

    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipo;
    private ArrayList<Rese�a> rese�as = new ArrayList<>();


   
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
    public void agregarRese�a() {
   String descripcion = JOptionPane.showInputDialog("Redacta tu rese�a :");
        int calificacion = Integer.parseInt(JOptionPane.showInputDialog("�Qu� calificaci�n le dar�as? (1-5)"
                + "\n[1] P�sima"
                + "\n[2] Mala"
                + "\n[3] Puede mejorar"
                + "\n[4] Buena"
                + "\n[5] Excelente"));
        Rese�a rese�a = new Rese�a(descripcion, calificacion);
        rese�as.add(rese�a);
        JOptionPane.showMessageDialog(null, "Rese�a agregada con �xito."); 
    }

    @Override
    public ArrayList<Rese�a> obtenerRese�as() {
      return rese�as;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.ArrayList;

/**
 *
 * @author POWER
 */
public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
   
    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.gestionpersonal;

import com.iudigital.gestionpersonal.controller.FuncionarioController;
import com.iudigital.gestionpersonal.domain.Funcionario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author caran
 */
public class Main {
    
    public static void crear(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite tipo identificacion:");
            int fktipoidentificacion = sc.nextInt();
            System.out.println("Digite estado civil:");
            int fkestadocivil = sc.nextInt();
            System.out.println("Digite sexo:");
            int fksexo = sc.nextInt();
            System.out.println("Digite nombre:");
            String nombre = sc.next();
            System.out.println("Digite apellido:");
            String apellido = sc.next();
            System.out.println("Digite numero identificacion:");
            String numeroidentificacion = sc.next();
            System.out.println("Digite direccion:");
            String direccion = sc.next();
            System.out.println("Digite fecha:");
            Date fechanacimiento = Date.valueOf(sc.next());
            System.out.println("Digite telefono:");
            String telefono = sc.next();
            System.out.println("--------------");
            
            Funcionario funcionario = new Funcionario();
            funcionario.setFkTipoIdentificacion(fktipoidentificacion);
            funcionario.setFkEstadoCivil(fkestadocivil);
            funcionario.setFkSexo(fksexo);      
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setNumeroIdentificacion(numeroidentificacion);
            funcionario.setDireccion(direccion);
            funcionario.setFechaNacimiento(fechanacimiento);
            funcionario.setTelefono(telefono);
            
            funcionarioController.crearFuncionario(funcionario);
            
            System.out.println("El funcionario se ha creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void listarFuncionarios(FuncionarioController funcionarioController) {
        try {
                        
            List<Funcionario> lista = funcionarioController.obtenerFuncionarios();
            
            for (Funcionario item : lista) {
                System.out.println(item);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void listarPorId(FuncionarioController funcionarioController) {
        try {
                                    
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa el id a consultar:");
            int id = sc.nextInt();
            
            Funcionario funcionario = funcionarioController.obtenerFuncionario(id);
            
            System.out.println(funcionario);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void actualizar(FuncionarioController funcionarioController) {
        try {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa el id para actualizar:");
            int id = sc.nextInt();
            
            Funcionario funcionario = funcionarioController.obtenerFuncionario(id);
            
            if (funcionario == null) {
                System.out.println("El funcionario no existe");
                return;
            }
            
            System.out.println("Digite tipo identificacion:");
            int fktipoidentificacion = sc.nextInt();
            System.out.println("Digite estado civil:");
            int fkestadocivil = sc.nextInt();
            System.out.println("Digite sexo:");
            int fksexo = sc.nextInt();
            System.out.println("Digite nombre:");
            String nombre = sc.next();
            System.out.println("Digite apellido:");
            String apellido = sc.next();
            System.out.println("Digite numero identificacion:");
            String numeroidentificacion = sc.next();
            System.out.println("Digite direccion:");
            String direccion = sc.next();
            System.out.println("Digite fecha:");
            Date fechanacimiento = Date.valueOf(sc.next());
            System.out.println("Digite telefono:");
            String telefono = sc.next();
            System.out.println("--------------");
            
            funcionario.setFkTipoIdentificacion(fktipoidentificacion);
            funcionario.setFkEstadoCivil(fkestadocivil);
            funcionario.setFkSexo(fksexo);
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setNumeroIdentificacion(numeroidentificacion);
            funcionario.setDireccion(direccion);
            funcionario.setFechaNacimiento(fechanacimiento);
            funcionario.setTelefono(telefono);
            
            funcionarioController.actulizarFuncionario(id, funcionario);   
           
            System.out.println("El funcionario se ha actualizado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void eliminar(FuncionarioController funcionarioController) {
        try {
                                    
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa el id para eliminar:");
            int id = sc.nextInt();
            
            funcionarioController.eliminarFuncionario(id);
            
            System.out.println("Se ha eliminado el registro con id: " + id);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
                
        FuncionarioController funcionarioController = new FuncionarioController();
        
        //'1990-01-27'
        //crear(funcionarioController);
        //listarPorId(funcionarioController);
        //actualizar(funcionarioController);
        //eliminar(funcionarioController);
        listarFuncionarios(funcionarioController);
        
    }
    
}

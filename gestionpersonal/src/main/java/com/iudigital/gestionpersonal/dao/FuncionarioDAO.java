/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.gestionpersonal.dao;

import com.iudigital.gestionpersonal.domain.Funcionario;
import com.iudigital.gestionpersonal.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caran
 */
public class FuncionarioDAO {
    
    private static final String GET_FUNCIONARIOS = "select * from funcionario";
    private static final String CREATE_FUNCIONARIO = "insert into funcionario(fktipoidentificacion, fkestadocivil, fksexo, nombre, apellido, numeroidentificacion, direccion, fechanacimiento, telefono) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionario where idfuncionario = ?";
    private static final String UPDATE_FUNCIONARIO = "update funcionario set fktipoidentificacion = ?, fkestadocivil = ?, fksexo = ?, nombre = ?, apellido= ?, numeroidentificacion= ?, direccion = ?, fechanacimiento= ?, telefono = ? where idfuncionario = ?";
    private static final String DELETE_FUNCIONARIO = "delete from funcionario where idfuncionario = ?";
    
    public void crearFuncionario(Funcionario funcionario) throws SQLException {
    
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionario.getFkTipoIdentificacion());
            preparedStatement.setInt(2, funcionario.getFkEstadoCivil());
            preparedStatement.setInt(3, funcionario.getFkSexo());
            preparedStatement.setString(4, funcionario.getNombre());
            preparedStatement.setString(5, funcionario.getApellido());
            preparedStatement.setString(6, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setDate(8, funcionario.getFechaNacimiento());
            preparedStatement.setString(9, funcionario.getTelefono());            
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        
        
    }
    
    public List<Funcionario> listarFuncionarios() throws SQLException {
    
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(resultSet.getInt("idfuncionario"));
                funcionario.setFkTipoIdentificacion(resultSet.getInt("fktipoidentificacion"));
                funcionario.setFkEstadoCivil(resultSet.getInt("fkestadocivil"));
                funcionario.setFkSexo(resultSet.getInt("fksexo"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numeroidentificacion"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setFechaNacimiento(resultSet.getDate("fechanacimiento"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionarios.add(funcionario);
            }
            
            return funcionarios;
            
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
            
        }
    }
    
    public Funcionario obtenerFuncionario(int idFuncionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, idFuncionario);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(resultSet.getInt("idfuncionario"));
                funcionario.setFkTipoIdentificacion(resultSet.getInt("fktipoidentificacion"));
                funcionario.setFkEstadoCivil(resultSet.getInt("fkestadocivil"));
                funcionario.setFkSexo(resultSet.getInt("fksexo"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numeroidentificacion"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setFechaNacimiento(resultSet.getDate("fechanacimiento"));
                funcionario.setTelefono(resultSet.getString("telefono"));
            }
            
            return funcionario;
            
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
            
        }
    }
    
    public void actualizarFuncionario(int idFuncionario, Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
                  
            preparedStatement.setInt(1, funcionario.getFkTipoIdentificacion());
            preparedStatement.setInt(2, funcionario.getFkEstadoCivil());
            preparedStatement.setInt(3, funcionario.getFkSexo());
            preparedStatement.setString(4, funcionario.getNombre());
            preparedStatement.setString(5, funcionario.getApellido());
            preparedStatement.setString(6, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setDate(8, funcionario.getFechaNacimiento());
            preparedStatement.setString(9, funcionario.getTelefono());
            preparedStatement.setInt(10, idFuncionario);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int idFuncionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, idFuncionario);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
}

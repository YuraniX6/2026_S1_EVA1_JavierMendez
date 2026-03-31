package cl.duoc.javiermendez.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.duoc.javiermendez.model.Paciente;

@Repository
public class RepositorioPaciente {

    private HashMap<Integer, Paciente> pacientesHospitalizados = new HashMap<>();
    //listar todos los pacientes
    public List<Paciente> obtenerPacientes(){
        return new ArrayList<>(pacientesHospitalizados.values());
    }
    //buscar pacientes por rut
    public Optional<Paciente> obtenerPacientePorRut(int rut){
        return Optional.ofNullable(pacientesHospitalizados.get(rut));
    }
    
    public Optional<Paciente> obtenerPacientePorNombre(String nombre){
        return Optional.ofNullable(pacientesHospitalizados.get(nombre));
    }
    //agregar nuevos pacientes
    public Paciente agregarPaciente(Paciente paciente){
        pacientesHospitalizados.put(paciente.getRut(), paciente);
        return paciente;
    }
    //eliminar pacientes por rut
    public void eliminarPaciente(int rut){
        pacientesHospitalizados.remove(rut);
    }
    //verificar si el paciente existe en el repositorio por rut
    public boolean existePaciente(int rut){
        return pacientesHospitalizados.containsKey(rut);
    }

}

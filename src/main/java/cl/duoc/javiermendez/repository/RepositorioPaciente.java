package cl.duoc.javiermendez.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.duoc.javiermendez.model.Paciente;

@Repository
public class RepositorioPaciente {

    private HashMap<Long, Paciente> pacientesHospitalizados = new HashMap<>();
    //listar todos los pacientes
    public List<Paciente> obtenerPacientes(){
        return new ArrayList<>(pacientesHospitalizados.values());
    }
    //buscar pacientes por id
    public Optional<Paciente> obtenerPacientePorId(Long id){
        return Optional.ofNullable(pacientesHospitalizados.get(id));
    }

    //buscar pacientes por rut
    public Optional<Paciente> obtenerPacientePorRut(Integer rut){
        return Optional.ofNullable(pacientesHospitalizados.get(rut));
    }
    
    //buscar pacientes por nombre
    public Optional<Paciente> obtenerPacientePorNombre(String nombre){
        return Optional.ofNullable(pacientesHospitalizados.get(nombre));
    }
    //agregar nuevos pacientes
    public Paciente agregarPaciente(Paciente paciente){
        pacientesHospitalizados.put(paciente.getId(), paciente);
        return paciente;
    }
    //eliminar pacientes por id
    public void eliminarPaciente(Long id){
        pacientesHospitalizados.remove(id);
    }
    //verificar si el paciente existe en el repositorio por id
    public boolean existePaciente(Long id){
        return pacientesHospitalizados.containsKey(id);
    }

}

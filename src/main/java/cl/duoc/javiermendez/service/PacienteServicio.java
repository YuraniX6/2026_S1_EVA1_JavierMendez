package cl.duoc.javiermendez.service;

import cl.duoc.javiermendez.model.Paciente;
import cl.duoc.javiermendez.repository.RepositorioPaciente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//metodos para el service
@Service
public class PacienteServicio {
    
    @Autowired
    private RepositorioPaciente repositorioPaciente;

    //constructor para inyectar el repositorio
    public PacienteServicio(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }
    
    //metodo para obtener todos los pacientes
    public List<Paciente> obtenerTodosPacientes(){
        return repositorioPaciente.obtenerPacientes();
    }

    //metodo para obtener un paciente por rut
    public Optional<Paciente> obtenerPacientePorRut(int rut){
        return repositorioPaciente.obtenerPacientePorRut(rut);
    }

    //metodo para agregar un nuevo paciente
    public Paciente agregarPaciente(Paciente paciente){
        return repositorioPaciente.agregarPaciente(paciente);
    }

    //metodo para eliminar un paciente por rut
    public boolean eliminarPaciente(int rut){
        if(repositorioPaciente.existePaciente(rut)){
            repositorioPaciente.eliminarPaciente(rut);
            return true;
        }
        return false;
    }

}

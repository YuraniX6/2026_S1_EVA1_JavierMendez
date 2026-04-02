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

    //metodo para obtener un paciente por id
    public Optional<Paciente> obtenerPacientePorId(Long id){
        return repositorioPaciente.obtenerPacientePorId(id);
    }

    //metodo para obtener un paciente por nombre
    public Optional<Paciente> obtenerPacientePorNombre(String nombre){
        return repositorioPaciente.obtenerPacientePorNombre(nombre);
    }


    //metodo para agregar un nuevo paciente
    public Paciente agregarPaciente(Paciente paciente){
        return repositorioPaciente.agregarPaciente(paciente);
    }

    //metodo para eliminar un paciente por rut
    public boolean eliminarPaciente(Long id){
        if(repositorioPaciente.existePaciente(id)){
            repositorioPaciente.eliminarPaciente(id);
            return true;
        }
        return false;
    }

    //metodo para actualizar un paciente por id
    public Paciente actualizarPaciente(Long id, Paciente paciente) {
        Optional<Paciente> pacienteExistente = repositorioPaciente.obtenerPacientePorId(id);
        if (pacienteExistente.isPresent()) {
            Paciente pacienteActualizado = pacienteExistente.get();
            pacienteActualizado.setId(id);
            pacienteActualizado.setRut(paciente.getRut());
            pacienteActualizado.setRutFinal(paciente.getRutFinal());
            pacienteActualizado.setNombre(paciente.getNombre());
            pacienteActualizado.setApellido(paciente.getApellido());
            pacienteActualizado.setFechaDeIngreso(paciente.getFechaDeIngreso());
            pacienteActualizado.setDireccion(paciente.getDireccion());
            pacienteActualizado.setTelefono(paciente.getTelefono());
            pacienteActualizado.setTipoAtencion(paciente.getTipoAtencion());
            pacienteActualizado.setNivelPrioridad(paciente.getNivelPrioridad());
            return repositorioPaciente.agregarPaciente(pacienteActualizado);
        } else {
            return null;
        }
    }
}
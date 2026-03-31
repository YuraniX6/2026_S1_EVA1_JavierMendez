package cl.duoc.javiermendez.controller;

import cl.duoc.javiermendez.model.Paciente;
import cl.duoc.javiermendez.service.PacienteServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/pacientes")
public class ControladorPaciente {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosPacientes(){
        return ResponseEntity.ok(pacienteServicio.obtenerTodosPacientes());
    }


}

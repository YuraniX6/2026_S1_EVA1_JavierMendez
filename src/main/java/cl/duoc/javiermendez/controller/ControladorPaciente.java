package cl.duoc.javiermendez.controller;

import cl.duoc.javiermendez.model.Paciente;
import cl.duoc.javiermendez.service.PacienteServicio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pacientes")
public class ControladorPaciente {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosPacientes() {
        return ResponseEntity.ok(pacienteServicio.obtenerTodosPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> obtenerPacientePorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteServicio.obtenerPacientePorId(id);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteServicio.agregarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteActualizado = pacienteServicio.actualizarPaciente(id, paciente);
        if (pacienteActualizado != null) {
            return ResponseEntity.ok(pacienteActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        boolean eliminado = pacienteServicio.eliminarPaciente(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

package cl.duoc.javiermendez.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    //Parametros del paciente

    private int rut;
    private String rutFinal;
    private String nombre;
    private String apellido;
    private String fechaDeIngreso;
    private String direccion;
    private int telefono;
    private String tipoAtencion;
    private String nivelPrioridad;

}

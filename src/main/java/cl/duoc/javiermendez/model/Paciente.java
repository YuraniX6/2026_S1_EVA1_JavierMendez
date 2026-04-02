package cl.duoc.javiermendez.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    //Parametros del paciente

    @NotNull(message = "El id no puede ser nulo")
    private Long id;

    @NotNull(message = "El rut no puede ser nulo")
    private Integer rut;

    @NotBlank(message = "El rut final no puede estar vacio")
    private String rutFinal;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotBlank(message = "La fecha de ingreso no puede estar vacia")
    private String fechaDeIngreso;

    @NotBlank(message = "La direccion no puede estar vacia")
    private String direccion;

    @NotNull(message = "El telefono no puede ser nulo")
    private Integer telefono;

    @NotBlank(message = "El tipo de atencion no puede estar vacio")
    private String tipoAtencion;

    @NotBlank(message = "El nivel de prioridad no puede estar vacio")
    private String nivelPrioridad;

}

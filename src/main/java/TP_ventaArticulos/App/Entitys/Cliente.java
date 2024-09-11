package TP_ventaArticulos.App.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni;
    private String apellido;
    private String nombre;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Factura> facturas = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "domicilio_id")
    @EqualsAndHashCode.Exclude // Evitar recursión en equals y hashCode
    @ToString.Exclude          // Evitar recursión en toString
    private Domicilio domicilio;

    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.facturas = new ArrayList<>();
    }
}


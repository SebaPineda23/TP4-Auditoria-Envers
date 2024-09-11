package TP_ventaArticulos.App.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name = "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private String denominacion;
    private int precio;
    @ManyToMany
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();
    @OneToMany(mappedBy = "articulo")
    @JsonIgnore
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();

    public Articulo( int cantidad, String denominacion, int precio) {
        this.cantidad=cantidad;
        this.denominacion=denominacion;
        this.precio=precio;
        this.categorias = new ArrayList<>(); // Asegurarse de inicializar la lista en el constructor
        this.detalleFacturas = new ArrayList<>();
    }
}

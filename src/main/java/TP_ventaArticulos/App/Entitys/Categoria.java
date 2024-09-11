package TP_ventaArticulos.App.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos = new ArrayList<>();

    public Categoria(String denominacion) {
        this.denominacion=denominacion;
        this.articulos= new ArrayList<>();
    }
}

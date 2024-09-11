package TP_ventaArticulos.App.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;


import java.util.ArrayList;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name = "detalle_factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private int subtototal;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_factura_id")
    private Factura factura;
}

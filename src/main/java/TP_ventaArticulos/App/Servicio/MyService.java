package TP_ventaArticulos.App.Servicio;

import TP_ventaArticulos.App.Entitys.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void run() {
        try {
            // Crear y persistir Domicilio primero
            Domicilio dom = new Domicilio("San Martin", 235);
            em.persist(dom);  // Persistir Domicilio

            // Luego crear y persistir Cliente
            Cliente cliente = new Cliente("Ruben", "Neres", 12344555);
            cliente.setDomicilio(dom);
            dom.setCliente(cliente);  // Establecer la referencia bidireccional
            em.persist(cliente);  // Persistir Cliente

            // Crear y persistir Factura
            Factura factura1 = new Factura();
            factura1.setNumero(12);
            factura1.setFecha("03/09/2024");
            factura1.setCliente(cliente);

            // Crear y persistir Categorías
            Categoria perecederos = new Categoria("Perecederos");
            Categoria lacteos = new Categoria("Lacteos");
            Categoria limpieza = new Categoria("Limpieza");
            em.persist(perecederos);
            em.persist(lacteos);
            em.persist(limpieza);

            // Crear y persistir Artículos
            Articulo art1 = new Articulo(200, "Yogurt Ser sabor frutilla", 20);
            Articulo art2 = new Articulo(300, "Detergente Magistral", 80);
            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            art2.getCategorias().add(limpieza);

            perecederos.getArticulos().add(art1);
            lacteos.getArticulos().add(art1);
            limpieza.getArticulos().add(art2);

            em.persist(art1);
            em.persist(art2);

            // Crear y persistir Detalles de Factura
            DetalleFactura detalleFactura1 = new DetalleFactura();
            detalleFactura1.setArticulo(art1);
            detalleFactura1.setCantidad(2);
            detalleFactura1.setSubtototal(40);
            detalleFactura1.setFactura(factura1);

            DetalleFactura detalleFactura2 = new DetalleFactura();
            detalleFactura2.setArticulo(art2);
            detalleFactura2.setCantidad(1);
            detalleFactura2.setSubtototal(80);
            detalleFactura2.setFactura(factura1);

            factura1.getDetalleFacturas().add(detalleFactura1);
            factura1.getDetalleFacturas().add(detalleFactura2);

            em.persist(detalleFactura1);
            em.persist(detalleFactura2);

            // Persistir la factura
            factura1.setTotal(120);
            em.persist(factura1);

            // La transacción se maneja automáticamente gracias a @Transactional

        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Relanza la excepción para que la transacción sea revertida
        }
    }
}

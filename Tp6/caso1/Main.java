package Tp6.caso1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Creacion de 5 productos
        Producto p1 = new Producto("A1", "Arroz 1Kg", 1200, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E1", "Auriculares Bluetooth", 2500, 15, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R1", "Campera", 3200, 8, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H1", "Licuadora", 2800, 10, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A2", "Yerba Mate 500g", 900, 30, CategoriaProducto.ALIMENTOS);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);

        // 2. Lista de prodoctos
        inventario.listarProductos();

        // 3. Buscar por id
        System.out.println("\n=== BUSCAR POR ID (E1) ===");
        Producto buscado = inventario.buscarProductoPorId("E1");
        if (buscado != null) buscado.mostrarInfo();
        else System.out.println("No encontrado.");

        // 4. Filtro
        System.out.println("\n=== FILTRAR POR CATEGORÍA: ALIMENTOS ===");
        ArrayList<Producto> alimentos = inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        for (Producto p : alimentos) p.mostrarInfo();

        // 5. Eliminar producto y listar
        System.out.println("\n=== ELIMINAR PRODUCTO (R1) ===");
        inventario.eliminarProducto("R1");
        inventario.listarProductos();

        // 6. Actualizar stock 
        System.out.println("\n=== ACTUALIZAR STOCK (A1 -> 70) ===");
        inventario.actualizarStock("A1", 70);

        // 7. Mostrar total de stock
        System.out.println("\n=== TOTAL STOCK ===");
        System.out.println("Total de unidades en inventario: " + inventario.obtenerTotalStock());

        // 8. Producto con mayor stock
        System.out.println("\n=== PRODUCTO CON MAYOR STOCK ===");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) mayorStock.mostrarInfo();

        // 9. Filtrar productos con precio entre 1000 y 3000
        System.out.println("\n=== FILTRAR POR PRECIO $1000 a $3000 ===");
        ArrayList<Producto> rangoPrecio = inventario.filtrarProductosPorPrecio(1000, 3000);
        for (Producto p : rangoPrecio) p.mostrarInfo();

        // 10. Mostrar categorías disponibles con descripción
        inventario.mostrarCategoriasDisponibles();
    }
}

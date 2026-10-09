package edu.taller.inventory;

import java.util.Objects;

public class InventoryProxy implements InventoryService {
    private final InventoryService realService;
    private final boolean accessAllowed;

    public InventoryProxy(InventoryService realService, boolean accessAllowed) {
        this.realService = Objects.requireNonNull(realService);
        this.accessAllowed = accessAllowed;
    }

    @Override
    public int getStock(String product) {
        if (!accessAllowed) {
            System.out.println("[Proxy] Acceso denegado: no se consulta el inventario real.");
            return 0;
        }
        System.out.println("[Proxy] Permiso validado.");
        return realService.getStock(product);
    }
}

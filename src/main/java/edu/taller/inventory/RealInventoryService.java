package edu.taller.inventory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RealInventoryService implements InventoryService {
    private final Map<String, Integer> stock = new ConcurrentHashMap<>(Map.of(
            "Balón de fútbol", 12,
            "Raqueta", 7,
            "Guantes", 20));

    @Override
    public int getStock(String product) {
        System.out.println("[Inventario real] Consultando existencias de " + product);
        return stock.getOrDefault(product, 0);
    }
}

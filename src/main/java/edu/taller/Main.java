package edu.taller;

import edu.taller.facade.OrderFacade;
import edu.taller.inventory.InventoryProxy;
import edu.taller.inventory.RealInventoryService;
import edu.taller.notification.BasicNotifier;
import edu.taller.notification.CompressionNotifier;
import edu.taller.notification.LoggingNotifier;
import edu.taller.payment.ExternalPaymentAdapter;
import edu.taller.payment.ExternalPaymentService;
import edu.taller.payment.PaymentProcessor;
import edu.taller.shipping.ShippingService;
import edu.taller.subsystem.OrderNotificationService;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor payment = new ExternalPaymentAdapter(new ExternalPaymentService());
        RealInventoryService realInventory = new RealInventoryService();
        InventoryProxy inventory = new InventoryProxy(realInventory, true);
        ShippingService shipping = new ShippingService();
        OrderNotificationService notifications = new OrderNotificationService(
                new CompressionNotifier(new LoggingNotifier(new BasicNotifier())));

        OrderFacade orders = new OrderFacade(inventory, payment, shipping, notifications);

        System.out.println("=== Compra completa ===");
        boolean completed = orders.purchase("Balón de fútbol", 80000, "cliente@ejemplo.com");
        System.out.println("Compra completada: " + completed);

        System.out.println("\n=== Consulta protegida de inventario ===");
        InventoryProxy restrictedInventory = new InventoryProxy(realInventory, false);
        System.out.println("Unidades disponibles: " + restrictedInventory.getStock("Balón de fútbol"));
    }
}

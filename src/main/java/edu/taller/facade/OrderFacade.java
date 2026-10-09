package edu.taller.facade;

import edu.taller.inventory.InventoryService;
import edu.taller.payment.PaymentProcessor;
import edu.taller.shipping.ShippingService;
import edu.taller.subsystem.OrderNotificationService;
import java.util.Objects;

/** Fachada que presenta el proceso de compra mediante una operación única. */
public class OrderFacade {
    private final InventoryService inventory;
    private final PaymentProcessor payment;
    private final ShippingService shipping;
    private final OrderNotificationService notifications;

    public OrderFacade(InventoryService inventory, PaymentProcessor payment,
                       ShippingService shipping, OrderNotificationService notifications) {
        this.inventory = Objects.requireNonNull(inventory);
        this.payment = Objects.requireNonNull(payment);
        this.shipping = Objects.requireNonNull(shipping);
        this.notifications = Objects.requireNonNull(notifications);
    }

    public boolean purchase(String product, double amount, String customerEmail) {
        if (product == null || product.isBlank() || customerEmail == null || customerEmail.isBlank()) {
            System.out.println("Producto y correo del cliente son obligatorios.");
            return false;
        }
        if (inventory.getStock(product) < 1) {
            System.out.println("Compra cancelada: producto sin existencias o acceso denegado.");
            return false;
        }
        if (!payment.processPayment(amount)) {
            System.out.println("Compra cancelada: no se pudo procesar el pago.");
            return false;
        }
        if (!shipping.arrangeShipment(product)) {
            System.out.println("Compra cancelada: no se pudo coordinar el envío.");
            return false;
        }
        notifications.notifyPurchase(customerEmail, product);
        return true;
    }
}

package edu.taller.subsystem;

import edu.taller.notification.Notifier;
import java.util.Objects;

public class OrderNotificationService {
    private final Notifier notifier;

    public OrderNotificationService(Notifier notifier) {
        this.notifier = Objects.requireNonNull(notifier);
    }

    public void notifyPurchase(String recipient, String product) {
        notifier.send(recipient, "Tu compra de " + product + " fue confirmada.");
    }
}

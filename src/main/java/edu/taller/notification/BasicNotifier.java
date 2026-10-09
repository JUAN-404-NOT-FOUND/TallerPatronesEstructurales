package edu.taller.notification;

public class BasicNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("Notificación enviada a %s: %s%n", recipient, message);
    }
}

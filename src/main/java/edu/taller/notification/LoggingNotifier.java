package edu.taller.notification;

public class LoggingNotifier extends NotifierDecorator {
    public LoggingNotifier(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("[LOG] Preparando notificación para " + recipient);
        wrapped.send(recipient, message);
    }
}

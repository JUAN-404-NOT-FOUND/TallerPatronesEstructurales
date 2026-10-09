package edu.taller.notification;

public class CompressionNotifier extends NotifierDecorator {
    public CompressionNotifier(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String recipient, String message) {
        String compressed = "[contenido comprimido: " + message.length() + " caracteres] " + message;
        wrapped.send(recipient, compressed);
    }
}

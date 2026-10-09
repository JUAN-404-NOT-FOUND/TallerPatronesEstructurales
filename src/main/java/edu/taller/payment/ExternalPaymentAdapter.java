package edu.taller.payment;

public class ExternalPaymentAdapter implements PaymentProcessor {
    private final ExternalPaymentService externalService;

    public ExternalPaymentAdapter(ExternalPaymentService externalService) {
        this.externalService = externalService;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("El monto del pago debe ser mayor que cero.");
            return false;
        }
        externalService.makeTransaction(amount);
        return true;
    }
}

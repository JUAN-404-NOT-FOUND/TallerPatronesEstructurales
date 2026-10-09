package edu.taller.payment;

import java.text.NumberFormat;
import java.util.Locale;

/** Simula una biblioteca externa cuya interfaz no se puede modificar. */
public class ExternalPaymentService {
    private static final NumberFormat COP_FORMAT = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));

    public void makeTransaction(double value) {
        System.out.println("Transacción externa completada por " + COP_FORMAT.format(value));
    }
}

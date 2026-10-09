# Taller: Patrones de Diseño Estructurales

Solución del taller basada en las situaciones entregadas. El proyecto usa Java 17 y Maven, sin dependencias externas.

## Respuestas de identificación

### Pregunta 1 — Decorator

El patrón adecuado es **Decorator**. Permite envolver un `Message` con objetos que añaden logging, cifrado y compresión. Los decoradores se pueden combinar y aplicar en distinto orden sin cambiar `BasicMessage` ni crear una clase para cada combinación.

### Pregunta 2 — Facade

El patrón adecuado es **Facade**. `OrderFacade` ofrece una operación sencilla (`purchase`) que coordina inventario, pago, envío y notificación. El controlador depende de una única interfaz y no necesita conocer el orden ni los detalles de esos subsistemas.

### Pregunta 3 — Proxy

El patrón adecuado es **Proxy**. Un objeto intermediario implementa la misma interfaz que el servicio y comprueba los permisos antes de delegar la consulta al servicio original. Así se conserva la forma de uso y se agrega control de acceso sin modificar el servicio.

### Pregunta 4 — Adapter

El patrón adecuado es **Adapter**. `ExternalPaymentAdapter` convierte la interfaz interna `PaymentProcessor.processPayment` en la llamada externa `ExternalPaymentService.makeTransaction`. El proveedor externo permanece intacto y el resto del programa conserva su interfaz esperada.



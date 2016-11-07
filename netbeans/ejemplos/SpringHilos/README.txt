Ejemplo de uso de hilos en aplicación web Spring.

- Se utiliza servicio con anotación @Async del framework Spring.
- Utilización de hilos con método "run" del objeto "Thread".
- Utilización y uso de excepción "UncaughtExceptionHandler" cuando un hilo encuentra un error desconocido en su ciclo de ejecución.
- Utilización de excepción "OutOfMemoryError" cuando la aplicación lanza un error con el mensaje "Java heap space" para que la ejecución del hilo continue hasta el final.
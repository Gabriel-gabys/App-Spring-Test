Ejemplo de uso de hilos en aplicaci�n web Spring.

- Se utiliza servicio con anotaci�n @Async del framework Spring.
- Utilizaci�n de hilos con m�todo "run" del objeto "Thread".
- Utilizaci�n y uso de excepci�n "UncaughtExceptionHandler" cuando un hilo encuentra un error desconocido en su ciclo de ejecuci�n.
- Utilizaci�n de excepci�n "OutOfMemoryError" cuando la aplicaci�n lanza un error con el mensaje "Java heap space" para que la ejecuci�n del hilo continue hasta el final.
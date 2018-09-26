# Ejercicio Java para Almundo

### Enunciado
Existe un call center donde hay 3 tipos de empleados: operador, supervisor
y director. El proceso de la atención de una llamada telefónica en primera
instancia debe ser atendida por un operador, si no hay ninguno libre debe
ser atendida por un supervisor, y de no haber tampoco supervisores libres
debe ser atendida por un director.

### Ejecución del ejercicio
- Se creó una base de datos en MongoDB porque se ajustaba facilmente a la estrategia de persistencia SingleTable para la clase Empleado y sus hijos.  (La data inicial para la base está en resources)
- Se dockerizó la aplicación y la base de datos (así como el seedeo de datos para la BD)
- Para correr el ejercicio, usar docker-compose up

### Requerimientos y soluciones
- Debe existir una clase Dispatcher encargada de manejar las llamadas, y debe contener el método dispatchCall para que las asigne a los empleados disponibles.
#### Clase Dispatcher y método creados
- El método dispatchCall puede invocarse por varios hilos al mismo tiempo.
#### El método dispatchCall se submitea al executorService
- La clase Dispatcher debe tener la capacidad de poder procesar 10 llamadas al mismo tiempo (de modo concurrente).
#### Configuración de los hilos en: ExecutorConfig
- Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos.
Debe tener un test unitario donde lleguen 10 llamadas.

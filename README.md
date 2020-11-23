### Universidad de Santiago de Chile
#### PEP 1: Sistemas Distribuidos
#### Williams Álvarez - Patricia Melo


# Link Git

https://github.com/willalv/PEP_Sistemas_Distribuidos

# Sistemas distribuidos:

Según Adrian Rodriguez (2019) un sistema distribuido es un conjunto de ordenadores que trabajan juntos de forma coordinada, a través del intercambio de mensajes, para conseguir un objetivo. En dicho sistema, el estado y los programas se guardan en múltiples ordenadores. A pesar de que los procesos que tienen lugar están separados entre los diferentes participantes, para el usuario parece que está trabajando con un único ordenador.
De acuerdo a la definición anterior un sistema distribuido de caracteriza por:
- **Concurrencia de los componentes:** Cada ordenador puede ejecutar procesos de manera independiente y en el mismo intervalo de tiempo que los otros.
- **Falta de un reloj global:** Como se tiene un conjunto de ordenadores, no existe un reloj global que determine el orden de las secuencias de eventos.
- **Fallos independientes de los componentes:** Si un componente falla, ya sea de software o hardware, los otros ordenadores no deben verse afectados por esta falla.

Además, los sistemas distribuidos presentan una serie de retos. Edu Salguero (2018) los define como: 
- **Transparencia:** Un sistema distribuido es transparente cuando logra presentarse frente a los usuarios y aplicaciones como si fuese un sistema que corre en una sola computadora.
- **Escalabilidad:** El sistema es escalable si al aumentar la demanda de servicios esto se puede suplir con una aportación de recursos (siempre y cuando el coste de añadir un usuario sea constante).
- **Disponibilidad:** Consiste en construir un sistema confiable a partir de partes no confiables, ya que el hardware o software puede fallar.
- **Heterogeneidad**: Esto hace referencia a la variedad y diferencia de elementos que se pueden encontrar en una red de computadores sobre la que se ejecuta un sistema distribuido. Esta variedad puede ser tanto de hardware como de software.
- **Seguridad:** Es el elemento más importante y complejo debido a la distribución física de equipos y sus conexiones. La encriptación puede proporcionar protección a los recursos compartidos si se transmiten por la red. Pero los ataques DoS siguen dando problemas.
- **Extensibilidad y apertura:** Esta característica hace referencia a la posibilidad de añadir nuevas características y servicios al sistema de manera dinámica.

Se desea que los sistemas distribuidos puedan lidiar con la heterogeneidad, también que la comunicación y distribución sea transparente para el usuario. Además, que haya consistencia de la interacción independiente de donde se lleve a cabo y que siempre funcione, independiente de las fallas que puedan ocurrir por partes. Es importante que el usuario y aplicaciones no noten caídas, reparaciones o inclusión de un nuevo hardware. 

# Análisis del Sistema

Las tecnologías utilizadas para el desarrollo del sistema fueron:
- Para el backend spring boot
- Para el frontend vue
- Para la base de datos postgreSQL

El sistema consta de un formulario para obtener un permiso temporal, en donde un usuario ingresa los datos solicitados y se genera dicho permiso. Para esto el frontend se conecta con el backend, este procesa los datos ingresados y posteriormente los guarda en la base de datos, como respuesta el backend envía los datos procesados al frontend para que sean visualizados al usuario.

Se puede decir que este no es un sistema distribuido, ya que todo se ejecuta en un único ordenador y de manera local, y a su vez no cumple con ninguna de las principales características de un sistema distribuido, como por ejemplo los fallos independientes de los componentes, ya que si el ordenador falla, el sistema completo se verá afectado y quedará inoperativo.
Con respecto a la serie de retos mencionados anteriormente, como es sistema no es distribuido no se cumple con ninguna de ellas.

# Pruebas realizadas

Se realizaron diferentes pruebas de cargas las cuales se mencionan a continuación: 
- Una persona envía 500 solicitudes de permisos temporales. Para este caso falló el envío de correos, solo se pudieron mandar 34 respuestas al mail de la persona. Sin embargo, eso corresponde a un problema de gmail, donde bloqueó temporalmente el correo que envía las dichas respuestas, ya que se considera spam.
- Una persona envía 500 solicitudes de permisos temporales. Esta vez no se enviaron mensajes de respuestas que validen la entrega de todos los permisos al correo, no obstante, se pudo comprobar que el sistema es capaz de responder y agregar estos permisos a la base de datos en un periodo de 4 segundos.
La media de respuestas por segundo fue: 144,93.
- Una persona envía 500 solicitudes de permisos temporales. En esta ocasión se decide emplear un mail falso que simula el envío de correos. Nuevamente se comprueba que el sistema es capaz de responder a todas esas solicitudes, e incluso si gmail no hubiese detenido la ejecución de mandar correos, estos también hubiesen funcionado. Se demoró en total 17 segundos en realizar todo el proceso.
La media de respuestas por segundo fue: 29,09.





# Referencias:

Salguero, E. (2018). *Sistemas distribuidos: caracterización, diseño, mensajes y tiempo (I)*. Recuperado de: https://medium.com/@edusalguero/sistemas-distribuidos-caracterizacion-modelado-comunicacion-tiempo-2c1f85f4e67a

Rodriguez, A. (2019).  *¿Qué es un sistema distribuido?*. Recuperado de:  https://adr-rod87.medium.com/qu%C3%A9-es-un-sistema-distribuido-442870a40bc4

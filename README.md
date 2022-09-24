Tabla de contenido
=================

   * GIT
      * Clone
      * Commit
      * ¿Cómo subir carpeta del directorio local al repositorio?
   
   * POOBCHIS
       * Malas prácticas
          * Principios SOLID
          * Modelo-Vista-Controlador
          * Unit Test    
       * PATTERNS
   
   # GUIT 
   ### Clone
   
   💻 Para clonar un proyecto se realiza los siguientes pasos:
   
   1. Ir a la pagina principal del respositorio. Encima de la lista de archivos, hacer clic en code
   
   ![image](https://user-images.githubusercontent.com/63822072/190725978-c6de5e2d-9d6f-4942-8cb5-65ad46cdd6b5.png)
   
   2. Copiar la direccion URL del repositorio 
   
  ![image](https://user-images.githubusercontent.com/63822072/190726187-3c88d843-ea5d-44eb-8677-fccc848784c5.png)
  
  3. Abrir Git Bash Here
  
  ![image](https://user-images.githubusercontent.com/63822072/190726397-bdab7d3b-ef6b-4c57-8e6b-a56989251140.png)
  
  4. En la consola escribir git clone y copiar la URL del repositorio 
  
  ![image](https://user-images.githubusercontent.com/63822072/190726647-9e9720eb-6ab0-4a4f-8ade-f33b910e70a6.png)

   ### Commit
   
   💻 Para hacer commit en un proyecto se realiza los siguientes pasos:
   
   1. Ir a la terminal de comandos 
   
   ![image](https://user-images.githubusercontent.com/63822072/190726950-b45ac467-68fe-47c8-b0b3-122e5a362968.png)

   2. Escribir git add .
   
   ![image](https://user-images.githubusercontent.com/63822072/190727803-dd9a1329-4f01-463c-8e46-961f52a72421.png)
  
  3. Escribir git commit -m "Algun mensaje"
  
  ![image](https://user-images.githubusercontent.com/63822072/190727869-dbfff945-a815-4d8a-9683-ad5768463943.png)

  4. Los cambios son guardados 
  
   ### ¿Cómo subir carpeta del directorio local al repositorio?
   
   💻 Para este caso utilizaremos un proyecto realizado en el semestre anterior, por lo que los pasos para para subirlo al repositorio fueron: 
   
   1. Descargar la carpeta 
   
   ![image](https://user-images.githubusercontent.com/63822072/190728470-795a9bf3-f8db-49ee-864f-a8d373a803c2.png)

  2. Ir a Git Hub y subir una nueva carpeta 
  
  ![image](https://user-images.githubusercontent.com/63822072/190728664-919eb2fc-1a2b-4d8a-9a8c-e3899d5afffa.png)

  3. Seleccionar la carpeta y esperar a que se cargue 
  
  # POOBCHIS 
  
  Es un juego de 2 a 4 jugadores aunque hay versiones para más jugadores. Requiere un tablero característico formado por un circuito de 100 casillas, 4 “casas” de diferentes colores: amarillo, rojo, verde y azul y diferentes comodines a lo largo del trayecto. Cada jugador dispone de 4 fichas del mismo color que su “casa”, hay diferentes tipos de fichas en el cual cada jugador puede escoger con que tipo de ficha va a jugar y un dado pero en otras versiones se juega con dos dados, sobre todo en internet. El objetivo del juego consiste en llevar todas las fichas desde su casa hasta la meta recorriendo todo el circuito, intentando “comerse” o capturar el resto de fichas en el camino. El primero en conseguirlo será el ganador.
  
  
   ## Malas prácticas 
   
   ### Principios SOLID
   
   ![image](https://user-images.githubusercontent.com/63822072/190729893-7a69e827-bd1b-45d8-b221-8efb37d72ca9.png)

   ### S: Principio de responsabilidad única
   
 Este principio se viola, debido a que la clase play se encarga de varios cosas. 
 Este principo establece que un componente o clase debe tener una responsabilidad única, sencilla y concreta, para que así se pueda simplificar el código al evitar que existan clases que cumplan con múltiples funciones, las cuales son difíciles de memorizar y muchas veces significan una pérdida de tiempo buscando qué parte del código hace qué función. Veamos lo siguiente     
 
 ### Método rollDices: Se encarga de lanzar los dados 
 
 ![image](https://user-images.githubusercontent.com/63822072/192096968-e7510dec-7241-44c0-a75e-6c66c2d7bec2.png)
 
 ### Método play: Lógica del juego 
 
 ![image](https://user-images.githubusercontent.com/63822072/192097014-072c6744-b23a-4882-af42-21b21058b010.png)

 ### Método getCasilla: Obtiene las casillas del juego 
 
 ![image](https://user-images.githubusercontent.com/63822072/192097049-d803ef68-9e32-4f45-a5e4-6530760d4f90.png)
 
  ###  🛠️ Solución 
   
   Para que cumpla con este principio podríamos hacer lo siguiente podriamos separar las responsabilidades de la clase, es decir, se crea otras clases que se encargue de las operaciones y sea mejor eficiente. 
  
   ### O: Principio abierto/cerrado
   
   ### 1. TIPO DE DADOS 
   
   Miremos el siguiente código: 
   
   ![image](https://user-images.githubusercontent.com/63822072/190731126-87591f02-99eb-49c4-8944-f339f78115e8.png)

   Si quisiéramos utilizar otro tipo de dado, no lo admitiría. 
   
   ###  🛠️ Solución 
   
   Para que cumpla con este principio podríamos hacer lo siguiente:
   
   Cada tipo de dado extiende la clase abstracta dado- 

   Así, cada dado tiene un tipo de dado diferente y el usuario podrá elegir con que tipo de dado quiere jugar.
   
   ### 2. TIPO DE FICHAS
   
   Si se quiere cambiar el tipo de ficha, se necesita de modificar el código dentro de la clase parchis
   
   ![image](https://user-images.githubusercontent.com/63822072/190749474-3b27f0a1-934a-45e8-966d-ac65096a9557.png)

  Si queremos utilizar otro tipo de ficha, no lo admitiria
  
  ###  🛠️ Solución 
  
   Para que cumpla con este principio podríamos hacer lo siguiente:
   Cada tipo de ficha extiende la clase piece  
   Así, cada ficha tiene un tipo de ficha diferente y el usuario podrá elegir con que tipo de ficha quiere jugar.
   
   ### L: Principio de substitución de Liskov
   
   En este principio, deducimos que está bien implementado, ya que podemos usar cualquiera de sus subclases sin interferir en la funcionalidad del programa.  
   
   ![image](https://user-images.githubusercontent.com/63822072/192097224-5ac67e36-90b7-400a-8aea-bcd4f0c7776a.png)
   

   ### I: Principio de segregación de interfaz
   
   En el codigo no exite interfaces 
   
   ![image](https://user-images.githubusercontent.com/63822072/192097894-1cc44b84-6b03-4e0b-bfcc-235638ac7c59.png)

   
   ###  🛠️ Solución 
  
  La solución a esto, sería crear una interfaz de objetos, en el cual no limite solo un tipo de pieza y/o un tipo de tablero 
  
  ![image](https://user-images.githubusercontent.com/63822072/192098280-e5f8c859-41da-436f-b031-add5f389e27d.png)

  
  
   ### D: Principio de inversión de dependencias

   Algunas partes están fuertemente acopladas 
   
   ![image](https://user-images.githubusercontent.com/63822072/192097397-daebeb99-0ac8-4151-9c16-0501cd5dd29b.png)

  ###  🛠️ Solución
  
  Para este principio, pensamos en implementar FACTORY METHOD como solución de este problema 
  
  ## FACTORY METHOD 
  
  Patrón de diseño creacional que proporciona una interfaz para crear objetos en una superclase, mientras permite a las subclases alterar el tipo de objetos que se crearán.
  El patrón Factory Method sugiere que, en lugar de llamar al operador new para construir objetos directamente, se invoque a un método fábrica especial (en este caso una clase que cree los diferentes objetos). Los objetos se siguen creando a través del operador new, pero se invocan desde el método fábrica. Los objetos devueltos por el método fábrica a menudo se denominan productos.
  
  Podemos llegar a crear una interfaz que se encargue de crear los objetos. 

   ### MVC
   
   Miremos las siguientes partes del codigo: 
   
   #### a) Clase parchis 
   ![image](https://user-images.githubusercontent.com/63822072/190774691-516c5930-c769-46c6-9e27-cd04e6f8bc82.png)
   
   ### b) Clase Pieces
   
   ![image](https://user-images.githubusercontent.com/63822072/190777834-91ce4f2f-1e44-49b5-a370-4b65224177bf.png)

  Podemos observar que en las clases de dominio o controlador se encuentran partes de código que deberían ir en la parte de vista o presentación. 
  
  ###  🛠️ Solución 
  
  La solución para este problema es poder trasladar ese código del controlador a la vista, sin tener que afectar el funcionamiento de la aplicación. 

   ### Unit Test 
   
   En el código no se encuentra ningún Test de prueba unitaria. 
   
   ###  🛠️Solución 
   
   Para este problema, se analizara los diferentes casos y se imaginará algunas opciones de nombramiento. 
   
   ### PATRON DE NOMBRAMIENTO 
   
      * GIVE RollDices WHEN turnoVentajosaOn THEN moveTotalMas1
      
  En esta "prueba unitaria" se pretende mostrar que cuando se lanzan los dados y el turno ventajosa está activo, entonces cada tres turnos, se mueve la sumatoria de lo que dieron los dados mas 1 
      
      * GIVE RollDices WHEN execute THEN changePlayer
      
  En esta prueba se pretende revisar que cuando se lanzan los dados y un jugador mueva sus fichas, cambie de turno y el otro jugador realice su lanzamiento 
       
      * GIVE RollDices WHEN NormalPiece THEN move
      
   En esta prueba se pretende revisar que cuando se lance los dados, el movimiento de las fichas sea el mismo al que salió en los dados. Es decir, si los dados sumaron 10, ese sea el movimiento que se hagan con las fichas. 
   
 La idea de poder llevar a cabo la implementacion de las pruebas es que cumplan con el principio FIRST, en el cual estos test se puedan ejecutar en cuestión de segundos y así poder detectar bugs de forma más rápida y sencilla. Además se piensa que todas deben de ser independientes de las otras y que el resultado de las pruebas debe ser el mismo independientemente del servidor o el sistema en el que se ejecute. 

      
      
   
  
   

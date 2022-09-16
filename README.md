Tabla de contenido
=================

   * [GIT](#GUIT)
      * [Clone](#clone)
      * [Commit](#commit)
      * [¿Cómo subir carpeta del directorio local al repositorio?](#¿Cómo-subir-carpeta-del-directorio-local-al-repositorio?)
   
   * [POOBCHIS](#poobchis)
       * [Malas prácticas](#Malas-practicas)
          * [Principios SOLID](#principios-solid)
          * [Modelo-Vista-Controlador](#modelo-vista-controlador)
          * [Unit Test](#unit-test)    
       * [PATTERNS](#patterns)
   
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
   
   Este principio se puede evidenciar de buena manera en el código planteado. Por ejemplo : 
   
   ![image](https://user-images.githubusercontent.com/63822072/190730398-f6a80302-d1d7-4b1d-9942-475486273f38.png)

  En esta imagen podemos ver que en el método play de la clase de parchis, se evidencia que cumple una unica responsabilidad que es la de llevar la lógica del juego propuesto. 
   
   
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
   
   Este principio se puede evidenciar de buena manera en el código planteado. Por ejemplo :
   
   ![image](https://user-images.githubusercontent.com/63822072/190756863-cd8059af-b07a-48af-a92e-50afd96a8791.png)
   
   En esta imagen podemos ver que la clase ventajosa abstrae los metodos de la clase extenida de piece, por lo que al utilizar la clase hija, el programa sigue siendo valido. 
   

   ### I: Principio de segregación de interfaz
   
   En el codigo no exite interfaces 
   
   ###  🛠️ Solución 
  
  La solución a esto, sería crear una interfaz de objetos, en el cual no limite solo un tipo de pieza y/o un tipo de tablero 
   ### D: Principio de inversión de dependencias

   
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
   
   Para este problema se dará varios ejemplos de cuáles podrían ser los test para esta aplicación. 
   
      * Dado_UnNumero_Cuando_EsTres_Entonces_SeGeneraTurnoVentajosa
      * Dado_UnNumero_Cuando_EsCinco_Entonces_SacaLaFichaDeLaCasa
      * Ddo_UnTipoDeTablero_Cuando_SeEscogeComodines_Entonces_LasCasillasAparecenConComodines
   
   ## Patterns 
      
   Programa fuertemente acoplado 
      
   ![image](https://user-images.githubusercontent.com/63822072/190795463-6cb93989-0d21-4110-b473-d72768163141.png)

   ![image](https://user-images.githubusercontent.com/63822072/190796306-1b026670-3f88-4ea7-8c0c-509ece3fcea8.png)

      
      
   
  
   

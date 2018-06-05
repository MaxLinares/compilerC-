-Antes de ejecutar la clase "Main.java" (del package Src>Scanner), se nombran
 2 métodos que son los principales:
	-generadorLexico();    //Primer Taller, Linea 15
	-generarParser();	//Segundo Taller, Linea 17
	-imprimir(); //Genera los archivos




Al ejecutarce "generadorLexico()":

-En primera instancia esta creada la clase "Lexer.java"
debido a que esta generada por haber hecho las pruebas anteriormente
-Una vez borrada la clase anteriormente nombrada
-Al Lexer.java se debe cambiar la línea 528 "Token"
por "java_cup.runtime.Symbol"

Luego "generarParser()":

-Se genera la estructura de nuestro archivo "Parser.cup" se generan
	-sym.java
	-Parser.java

Para finalizar "imprimir()":
-inicializa las clases de AST, para crear el árbol de Parser y grapher 
tambien genera el archivo .dot

En el uso:
- En la línea 25 de la misma clase ("main.java" del package src>Scanner)
 es donde actualmente se encuentra el archivo por defecto "Programa4.cmt"
en el cual ese nombre puede cambiarse para ir probando los siguientes
 ejemplos.






















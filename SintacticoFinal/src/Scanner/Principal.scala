
package Scanner

import java.io._
import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.io.PrintWriter
import java.io.Reader
import java.util.Stack
import java.util.logging.Level
import java.util.logging.Logger
import GraphVisitor._
import Parser._

import scala.io.Source
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

object Principal {
  


def main(args: Array[String]) = {
//declaro mi archivo y lo abro
    val archivo = "ejemplo1.txt"
    try{
      
     // val lexer : Lexer = new Lexer(new BufferedReader(new FileReader("""E:\Programas\Eclipse\Workspace\Sintactico\ejemplo1.txt"""))) 

     val fileContents = Source.fromFile(archivo).getLines.mkString
      //leo cada linea, guardandola en mi variable "line"
    /*  for (line <- Source.fromFile(archivo).getLines) {
          //imprimo todas las lineas de mi archivo
          println(line)
      }*/ 
      println(fileContents)
      
      //lexer = new Lexer(fileContents)
      
      
      
    }catch{
      case ex: Exception => println("ERROR al intentar leer el archivo")
    }

}






}
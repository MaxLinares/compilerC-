package Ast

import java.util.Collections
import Visitor.AstVisitor
import Parser._

import scala.collection.JavaConversions._

class AstExpBin(tipo: Int, exp1: AstNode,  exp2: AstNode) extends AstNode {

  private var valor2: String = _   //Valor para guardar segunda expresion.

  //this.nNodo = GrapherVisitor.identNodo += 1
  //private var _tipo: String= "" <Debe borrarse si es que no la ocupo>
  private var _exp1: AstNode= null 
  private var _exp2: AstNode= null
  
  tipo match {
    
    case sym.MENORIGUAL => setTipo("MENOR IGUAL")
    case sym.MENORQUE => setTipo("MENOR QUE")
    case sym.MAYORQUE => setTipo("MAYOR QUE")
    case sym.MAYORIGUAL => setTipo("MAYOR IGUAL")
    case sym.IGUALDAD => setTipo("IGUALDAD")
    case sym.DISTINTO => setTipo("DISTINTO")
    case sym.SUMA => setTipo("SUMA")
    case sym.RESTA => setTipo("RESTA")
    case sym.MULTIPLICACION => setTipo("MULTIPLICACION")
    case sym.DIVISION => setTipo("DIVISION")
    case _ => setTipo("")
  }
  //"Metodo" que le asigna los padres a la exp1.
  if (exp1 != null) {
    getHijos().add(exp1)
    exp1.setPadre(this)
    this.setValor(exp1.getValor)
    var verdad = true
    while (verdad==true) {
      //Deja de asignar padres si no hay mas hermanos para el nodo inicial.
      if (exp1.getHermano == null) {
        verdad= false
      }else{
      getHijos().add(exp1.getHermano)
      exp1.getHermano.setPadre(this)
      //Lo copio
      exp1.copiarNodo(exp1.getHermano())
      }
    }
    verdad= true
  }
var verdad2= true
  if (exp2 != null) {
    this.hijos.add(exp2)
    exp2.setPadre(this)
    this.valor2 = exp2.getValor
    while (verdad2==true) {
      if (exp2.getHermano == null) {
        verdad2= false
      }else{
      this.hijos.add(exp2.getHermano)
      exp2.getHermano.setPadre(this)
      //Lo copio
      exp2.copiarNodo(exp2.getHermano())
      }
    }
    verdad2 = false
  }
  //Se invierte la lista para tener el orden correcto.
  Collections.reverse(this.hijos)

   override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  
  def getValor2(): String = valor2

  def setValor2(valor2: String) {
    this.valor2 = valor2
  }
}

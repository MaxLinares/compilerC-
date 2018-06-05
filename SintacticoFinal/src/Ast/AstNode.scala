package Ast

import java.util.LinkedList
import GraphVisitor.GrapherVisitor
import scala.collection.JavaConversions._
import Visitor._

abstract class AstNode {
  private var nNodo: Int = 0
  private var padre: AstNode = null
  private var hermano: AstNode = null
  var hijos: LinkedList[AstNode] = new LinkedList()
  
  private var tipo: String = ""
  private var valor: String = ""
  
  def getNNodo(): Int = this.nNodo
  def getPadre(): AstNode = this.padre
  def getHermano(): AstNode = this.hermano
  def getHijos(): LinkedList[AstNode] = this.hijos
  def getTipo(): String = this.tipo
  
  def setNNodo( nodoN: Int) {
    this.nNodo = nodoN
  }
  def setPadre(pad: AstNode) {
    this.padre = pad
  }
  def setHermano(her: AstNode) {
    this.hermano = her
  }
  def setHijos(hij: LinkedList[AstNode]) {
    this.hijos = hij
  }
  def setTipo(tip: String) {
    this.tipo = tip
  }
  //metodo para copiar un nodo
  def copiarNodo(nodo:AstNode){
    this.nNodo=nodo.getNNodo()
    this.padre=nodo.getPadre()
    this.hermano=nodo.getHermano()
    this.hijos=nodo.getHijos()
    this.tipo=nodo.getTipo()
    this.valor=nodo.getValor()
  }
  def recorrerArbol(visitor: AstVisitor) {
    //Hace caso omiso si el nodo se encuentra en el arreglo. 
    //(No permite duplicado).
    val nodoVisitor= new GrapherVisitor()
    
    //if (GrapherVisitor.nodoVisitados.contains(this.nNodo)) {
    if (nodoVisitor.nodoVisitados.contains(this.nNodo)) {
      return
    }
    
    //GrapherVisitor.nodoVisitados.add(this.nNodo)
    nodoVisitor.nodoVisitados.add(this.nNodo) 
    
    accept(visitor)
    //Recorro el arbol bottom-up
    for (nodo <- hijos) {
      if (nodo != null) nodo.recorrerArbol(visitor)
      }
  }
  
//  def retornaCadenaGraph(): String = {
//    var cadena = ""
//    cadena = cadena.concat(this.cadenaAsociados)
//    cadena = cadena.concat(this.cadenaRelaciones)
//    cadena += "}"
//    cadena
//  }
	
  def accept(visitor: AstVisitor) 
  def getValor(): String = valor

  def setValor(valor: String) {
    this.valor = valor
  }
}


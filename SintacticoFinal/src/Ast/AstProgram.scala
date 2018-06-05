package Ast

import java.util.ArrayList
import java.util.Collections
import GraphVisitor.GrapherVisitor
import Visitor.AstVisitor
import scala.collection.JavaConversions._

class AstProgram(var dl: AstNode) extends AstNode {

  //this.setNNodo( GrapherVisitor.identNodo += 1)
  
var verdad= true

  if (dl != null) {
    this.hijos.add(dl)
    dl.setPadre(this)
    
    while (verdad == true) {
      if (dl.getHermano == null) {
        verdad= false;
      }else{
      this.hijos.add(dl.getHermano)
      dl.getHermano.setPadre(this)
      //copio el hermano; 
      dl=dl.getHermano
      //dl.copiarNodo(dl.getHermano)
    }
  }
    verdad= true
  }
  
  //Se invierte la lista para tener el orden correcto.
  Collections.reverse(this.hijos)
  override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  
  
}
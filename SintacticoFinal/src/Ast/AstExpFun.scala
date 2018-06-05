package Ast

import java.util.Collections
//import GraphVisitor.GrapherVisitor
//import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._
import Visitor.AstVisitor
class AstExpFun(var id: String,var arg: AstNode) extends AstNode {
  var verdad= true
  protected var ident: String = id

  //this.nNodo = GrapherVisitor.identNodo += 1

  setTipo( "id")

  if (arg != null) {
    this.setValor(arg.getValor)
    this.hijos.add(arg)
    arg.setPadre(this)
    while (verdad == true) {
      if (arg.getHermano == null) {
        verdad=false
      }else{
      this.hijos.add(arg.getHermano)
      arg.getHermano.setPadre(this)
      arg = arg.getHermano
      }
    }
  }
  verdad= true

  Collections.reverse(this.hijos)

  override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  

  def getIdent(): String = ident

  def setIdent(ident: String) {
    this.ident = ident
  }
}

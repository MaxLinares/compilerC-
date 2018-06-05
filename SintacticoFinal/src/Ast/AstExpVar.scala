package Ast

import java.util.Collections
//import GraphVisitor.GrapherVisitor
import Parser.sym
//remove if not needed
import Visitor.AstVisitor
import scala.collection.JavaConversions._

class AstExpVar(var exp: AstNode,var id: String,var corch: Boolean) extends AstNode {

  protected var ident: String = id

  protected var corchetes: Boolean = corch

  //this.nNodo = GrapherVisitor.identNodo += 1

  setTipo(if (this.corchetes == true) "conOperacion" else "sinOperacion")

  var verdad = true  
  if (exp != null) {
    setValor(exp.getValor)
    this.hijos.add(exp)
    exp.setPadre(this)
    while (verdad==true) {
      if (exp.getHermano == null) {
        verdad= false
      }else{
      this.hijos.add(exp.getHermano)
      exp.getHermano.setPadre(this)
      exp = exp.getHermano
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

  def isCorchetes(): Boolean = corchetes

  def setCorchetes(corchetes: Boolean) {
    this.corchetes = corchetes
  }
}

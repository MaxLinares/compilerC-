package Ast

import java_cup.runtime.Symbol
//import GraphVisitor.GrapherVisitor
import Parser._
import Visitor.AstVisitor

import scala.collection.JavaConversions._

class AstVarDec(tipoLlega: Int,id: String, corch: Boolean, num: String) extends AstNode {

  var ident: String = id

  var corchetes: Boolean = corch

  var valor: String = ""

  //this.nNodo = GrapherVisitor.identNodo += 1

  if (this.corchetes == false) {
    if (tipoLlega == sym.VOID) {
      this.setTipo("void")
    } else {
      this.setTipo("int")
    }
  } else {
    this.setValor(num)
    if (tipoLlega == sym.VOID) {
      this.setTipo("void[" + this.getValor + "]")
    } else {
      this.setTipo("int[" + this.getValor + "]")
    }
  }
  
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

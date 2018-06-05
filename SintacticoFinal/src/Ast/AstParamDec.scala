package Ast


import Parser.sym

//remove if not needed
import scala.collection.JavaConversions._
import Visitor.AstVisitor

class AstParamDec(tipoLlega: Int, id: String, corch: Boolean) extends AstNode {

  protected var ident: String = id

  protected var corchetes: Boolean = corch

  protected var valor: String = _

  protected var tipos: Int = tipoLlega

  //this.nNodo = GrapherVisitor.identNodo += 1

  setTipo (if (this.corchetes == false) if (this.tipos == sym.VOID) "void" else "int" else if (this.tipos == sym.VOID) "void[]" else "int[]")

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

  //def getValor(): String = valor

 /* def setValor(valor: String) {
    this.valor = valor
  }*/

  def getTipos(): Int = tipos

  def setTipos(tipos: Int) {
    this.tipos = tipos
  }
}


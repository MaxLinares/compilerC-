package Ast

//import GraphVisitor.GrapherVisitor
import Parser.sym
import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._


class AstReturnStmt(exp: AstNode) extends AstNode {

  protected var tipos: Int = _

 // this.nNodo = GrapherVisitor.identNodo + 1

  if (exp != null) {
    this.setValor(exp.getTipo)

    if (exp != null) {
      exp.setPadre(this)
      this.hijos.add(exp)
    }
    this.hijos.add(exp)
    this.setTipo(exp.getTipo)
  } else {
    this.setTipo("void")
  }

   override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
}
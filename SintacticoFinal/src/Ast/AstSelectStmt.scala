package Ast

import java.util.Collections
//import GraphVisitor.GrapherVisitor
import Parser.sym
import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._

class AstSelectStmt(var exp: AstNode,var stmtIf: AstNode,var stmtElse: AstNode,var tendraElse: Boolean) extends AstNode {
var verdad= true
  protected var tieneElse: Boolean = tendraElse

  //this.nNodo = GrapherVisitor.identNodo += 1

  setTipo( if (tieneElse == true) "else" else "if")

  if (exp != null) {
    this.hijos.add(exp)
    exp.setPadre(this)
  }

  if (stmtIf != null) {
    this.hijos.add(stmtIf)
    stmtIf.setPadre(this)
    while (verdad ==true) {
      if (stmtIf.getHermano == null) {
        verdad= false
      }else{
      this.hijos.add(stmtIf.getHermano)
      stmtIf.getHermano.setPadre(this)
      stmtIf = stmtIf.getHermano
      }
    }
  }
  verdad= true

  if (stmtElse != null) {
    this.hijos.add(stmtElse)
    stmtElse.setPadre(this)
    while (verdad==true) {
      if (stmtElse.getHermano == null) {
        verdad= false
      }else{
      this.hijos.add(stmtElse.getHermano)
      stmtElse.getHermano.setPadre(this)
      stmtElse = stmtElse.getHermano
    }
    }
  }
  verdad= true

  Collections.reverse(this.hijos)

  override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  

  def isTieneElse(): Boolean = tieneElse

  def setTieneElse(tieneElse: Boolean) {
    this.tieneElse = tieneElse
  }
}

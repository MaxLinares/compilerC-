package Ast

import java.util.Collections
//import GraphVisitor.GrapherVisitor
import Parser._
import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._

class AstIterStmt(var exp: AstNode) extends AstNode {

  //this.nNodo = GrapherVisitor.identNodo + 1
  
  var tieneDoWhile = false		

  def this( exp: AstNode, stmt: AstNode, tendraDoWhile: Boolean) = {

  	  this(exp)
	  
	  this.setTipo(if (this.tieneDoWhile == true) "do" else "while")   

	  if (exp != null) {
	    this.hijos.add(exp)
	    exp.setPadre(this)
	  }

	  if (stmt != null) {
	    this.hijos.add(stmt)
	    stmt.setPadre(this)
	    while (stmt.getHermano != null) {
	      this.hijos.add(stmt.getHermano)
	      stmt.getHermano.setPadre(this)
	      //
	      stmt.copiarNodo(stmt.getHermano)	
	    }
	  }
	  Collections.reverse(this.hijos)	
  }

  def this(exp: AstNode, 
      exp2: AstNode, 
      exp3: AstNode, 
      stmt: AstNode) = {
    this(exp)
    this.setTipo("for") 
    if (exp != null) {
      this.hijos.add(exp)
      exp.setPadre(this)
    }
    if (exp2 != null) {
      this.hijos.add(exp2)
      exp2.setPadre(this)
    }
    if (exp3 != null) {
      this.hijos.add(exp3)
      exp3.setPadre(this)
    }
    if (stmt != null) {
      this.hijos.add(stmt)
      stmt.setPadre(this)
      while (stmt.getHermano != null) {
        this.hijos.add(stmt.getHermano)
        stmt.getHermano.setPadre(this)
        stmt.copiarNodo(stmt.getHermano)
      }
    }
    Collections.reverse(this.hijos)
  }
  
  override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
	
  def isTieneDoWhile(): Boolean = tieneDoWhile

  def setTieneDoWhile(tieneDoWhile: Boolean) {
    this.tieneDoWhile = tieneDoWhile
  }
}
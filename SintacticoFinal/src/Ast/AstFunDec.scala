package Ast

import java.util.Collections
import Parser.sym
import Visitor.AstVisitor
//import GraphVisitor.GrapherVisitor
//remove if not needed
import scala.collection.JavaConversions._

class AstFunDec(tipoLlega: Int,id: String,params: AstNode,comp: AstNode) extends AstNode {

  var verdad = true
  private var ident: String = id

  private var tipos: Int = tipoLlega

  //this.nNodo = GrapherVisitor.identNodo += 1

  setTipo(if (this.tipos == sym.VOID) "void" else "int") 

  if (params != null) {
    this.hijos.add(params)
    params.setPadre(this)
    
    while (verdad==true) {
      if (params.getHermano == null) {
        verdad=false
      }else{
      this.hijos.add(params.getHermano)
      params.getHermano.setPadre(this)
      
      params.copiarNodo(params.getHermano)
      }
    }
    verdad= true
  }

  this.hijos.add(comp)

  if (comp != null) {
    comp.setPadre(this)
  }

  Collections.reverse(this.hijos)
  
  override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
	
  def getIdent(): String = ident

  def setIdent(ident: String) {
    this.ident = ident
  }

  def getTipos(): Int = tipos

  def setTipos(tipos: Int) {
    this.tipos = tipos
  }
}

package Ast

//import GraphVisitor.GrapherVisitor
//import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._
import Visitor.AstVisitor

class AstExpAsign(var vari: AstNode,var exp: AstNode,var tipo: Int) extends AstNode {
var verdad= true
  setTipo( java.lang.Integer.toString(tipo))

  //setNNodo( GrapherVisitor.identNodo += 1)

  setValor(exp.getValor)

if (vari != null) {
    this.hijos.add(vari)
    vari.setPadre(this)
    while (verdad==true) {
      if (vari.getHermano == null) {
        verdad= false
      }else{
      this.hijos.add(vari.getHermano)
      vari.getHermano.setPadre(this)
      vari = vari.getHermano
      }
      }
  }
verdad= true

  if (exp != null) {
    this.hijos.add(exp)
    exp.setPadre(this)
    while (verdad==true) {
     if (exp.getHermano == null) {
        verdad= false
      }
      this.hijos.add(exp.getHermano)
      exp.getHermano.setPadre(this)
      exp = exp.getHermano
    }
  }
verdad= true

 override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  

 
}
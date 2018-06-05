package Ast


import java.util.Collections

import scala.collection.JavaConversions._
import GraphVisitor.GrapherVisitor
import Visitor.AstVisitor

class AstCompStmt(var locDec: AstNode, var stmtList: AstNode) extends AstNode {

 // this.nNodo = GrapherVisitor.identNodo += 1
 var verdad = true
  
  if (stmtList != null) {
    this.hijos.add(stmtList)
    stmtList.setPadre(this)
    while (verdad==true) {
      if (stmtList.getHermano == null) {
        verdad = false
      }else{
      this.hijos.add(stmtList.getHermano)
      stmtList.getHermano.setPadre(this)
      stmtList = stmtList.getHermano
      }
    }
    verdad= true
  }

  if (locDec != null) {
    this.hijos.add(locDec)
    locDec.setPadre(this)
    while (verdad==true) {
      if (locDec.getHermano == null) {
        verdad = false
      }else{
      this.hijos.add(locDec.getHermano)
      locDec.getHermano.setPadre(this)
      locDec = locDec.getHermano
    }
    }
    verdad= true
    
  }

  Collections.reverse(this.hijos)

 override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  
  
}
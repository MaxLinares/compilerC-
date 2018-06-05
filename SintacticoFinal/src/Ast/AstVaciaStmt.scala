package Ast

//import GraphVisitor.GrapherVisitor
import Parser.sym
import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._

class AstVaciaStmt extends AstNode {

  //this.nNodo = GrapherVisitor.identNodo += 1

  setTipo( java.lang.Integer.toString(sym.VOID))

 override def accept(visitor: AstVisitor) {
    //visitor.visit(this)
  }


}
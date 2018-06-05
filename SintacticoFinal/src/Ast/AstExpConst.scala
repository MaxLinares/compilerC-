package Ast
import Visitor.AstVisitor
//import GraphVisitor.GrapherVisitor
//import Visitor.AstVisitor
//remove if not needed
import scala.collection.JavaConversions._

class AstExpConst(var num: String) extends AstNode {

  //this.nNodo = GrapherVisitor.identNodo += 1

  this.setTipo("int")

  this.setValor(num)

 override def accept(visitor: AstVisitor) {
    visitor.visit(this)
  }
  
 
}
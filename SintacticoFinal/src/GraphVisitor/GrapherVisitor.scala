package GraphVisitor

import java.util.ArrayList
import Ast._
import Visitor.AstVisitor
import GraphVisitor._
import scala.collection.JavaConversions._

class GrapherVisitor extends AstVisitor{
  //variables que se encarga de concatener los arreglos para generar el graph.
  var nodoVisitados: ArrayList[Integer] = new ArrayList()
  
  //Esta variable es para incrementar los nodos que se 
  //utilizaran, y que no se repitan
  var identNodo: Int = 0
  
  //Esta variable puedo haber estado en
  //cualquier lado hasta en el main pero al
  var cadenaRelaciones:String=""
  
  //Utilizar esta herramienta del visitor para utilizar la abstraccion es mas 
  //correcto declararlo en la herrramienta.
  var cadenaAsociados: String = "digraph g {\n"
  
  class GrapherVisitor(){
    //Inicia la variable con este String ya
    //que es la sintaxis para generar el graph.
    cadenaAsociados="digraph g {\n";
    //Se inicilizan los nodos en 0 (indice).
    identNodo=0;
  }
   override def visit(visitor: AstProgram) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Programa{}\"];\n"
  }

  override def visit(visitor: AstVarDec) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"" + 
      "Variable, " + 
      visitor.getIdent + 
      " " + 
      visitor.getTipo + 
      "\"];\n"
  }

  override def visit(visitor: AstFunDec) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"" + 
      "Funcion: " + 
      visitor.getTipo + 
      " " + 
      visitor.getIdent + 
      "\"];\n"
  }

  override def visit(visitor: AstParamDec) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (visitor.isCorchetes) {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"" + 
        "Parametro: " + 
        visitor.getTipo + 
        "\"];\n"
    } else {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"" + 
        "Parametro: " + 
        visitor.getTipo + 
        "\"];\n"
    }
  }

  override def visit(visitor: AstCompStmt) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Cuerpo{}\"];\n"
  }

  override def visit(visitor: AstVaciaStmt) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Vacio\"];\n"
  }

  override def visit(visitor: AstSelectStmt) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (!visitor.isTieneElse) {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Else{}\"];\n"
    } else {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"If{}\"];\n"
    }
  }

  override def visit(visitor: AstIterStmt) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (!visitor.isTieneDoWhile) {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"For{}\"];\n"
    } else {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"While{}\"];\n"
    }
  }

  override def visit(visitor: AstReturnStmt) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Return " + 
      visitor.getTipo + 
      ";\"];\n"
  }

  override def visit(visitor: AstExpAsign) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (visitor.getValor == null) {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Asignacion\"];\n"
    } else {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Asignacion, Valor: " + 
        visitor.getValor + 
        "\"];\n"
    }
  }

  override def visit(visitor: AstExpVar) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (!visitor.isCorchetes) {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Expresion, " + 
        visitor.getIdent + 
        "  " + 
        visitor.getValor + 
        "\"];\n"
    } else {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Expresion, " + 
        visitor.getIdent + 
        "[Expresion] = " + 
        visitor.getValor + 
        "\"];\n"
    }
  }

  override def visit(visitor: AstExpBin) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    var operacion = visitor.getTipo
    operacion match {
      case "Menor igual" => operacion = "<="
      case "Menor" => operacion = "<"
      case "Mayor igual" => operacion = ">="
      case "Mayor" => operacion = ">"
      case "Igual igual" => operacion = "=="
      case "Distinto" => operacion = "<>"
      case "Suma" => operacion = "+"
      case "Resta" => operacion = "-"
      case "Multiplicacion" => operacion = "*"
      case "Division" => operacion = "/"
      case _ => operacion = "Desconocido"
    }
    this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Operacion,  " + 
      visitor.getValor + 
      " " + 
      operacion + 
      " " + 
      visitor.getValor2 + 
      "\"];\n"
  }

  override def visit(visitor: AstExpConst) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (visitor.getTipo == "int") {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Constante, " + 
        visitor.getValor + 
        "\"];\n"
    }
  }

  override def visit(visitor: AstExpFun) {
    val padre = visitor.getPadre
    if (padre != null) {
      this.cadenaRelaciones += java.lang.Integer.toString(padre.getNNodo) + "->" + java.lang.Integer.toString(visitor.getNNodo) + 
        ";\n"
    }
    if (visitor.getTipo == "void") {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Call, " + 
        visitor.getIdent + 
        "(args)" + 
        "\"];\n"
    } else {
      this.cadenaAsociados += java.lang.Integer.toString(visitor.getNNodo) + " [label=\"Valor, " + 
        visitor.getValor + 
        "\"];\n"
    }
  }

  override def retornaCadenaGraph(): String = {
    var cadena = ""
    cadena = cadena.concat(this.cadenaAsociados)
    cadena = cadena.concat(this.cadenaRelaciones)
    cadena += "}"
    cadena
  }
  //penultima linea
}  










package Scanner;
import Parser.*;

import java.io.*;
import java.util.Stack;

import GraphVisitor.GrapherVisitor;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Generador a = new Generador();
			//crea el Lexer.java
	      //a.generadorLexico();
			//crea el Parser.java
	      //a.generarParser();
		//inicializa el parser y grapher y genera el archivo .dot
		imprimir();
	}
	
	@SuppressWarnings("deprecation")
	public static void imprimir()throws FileNotFoundException, IOException{
		
		File fichero = new File ("ejemplo.cmp");
		
        
        Reader reader = new BufferedReader(new FileReader(fichero));
        //Creo mi objeto Lexer
        Lexer lexer;
        //Paso al Lexer mi archivo para que lo lea
        lexer = new Lexer (reader);
        String resultado="";
		Parser parser = new Parser(lexer);
        try{
            parser.debug_parse();
    		//Se crea la estructura visitor.
    		GrapherVisitor vist = new GrapherVisitor();
    		//Se obtiene el nodo raiz.
    		parser.raiz.recorrerArbol(vist);
    		//Cadena que contiene el grapher.
    		String cadenaGraph = vist.retornaCadenaGraph();
    		
    		generarArchivoDot(cadenaGraph); //Metodo que genera el archivo .dot.
    		String  nomArch = "result.txt";
    		generarSalida(parser.produc,nomArch); //Traspasa las producciones a un archivo.
    		invertirArchivo(nomArch); //Invierte el archivo.
    		resultado = cadenaGraph; 
                //jTextArea1.setText(resultado);//Ademas de generar el archivo .dot lo imprime.
        } catch (Exception e) {
                // TODO Auto-generated catch block
        	System.out.println("Error en Graph");
                e.printStackTrace();
        }
	      
	}
	/*Metodo que genera archivo .dot.*/
    public static void generarArchivoDot(String cadenaPathDot){
        try {
                File rutaResult = new File(System.getProperty("user.dir")+ "/" + "prueba.dot");
            BufferedWriter wr;
                wr = new BufferedWriter(new FileWriter(rutaResult));
                wr.write(cadenaPathDot);
                wr.close();
                System.out.println("Archivo .DOT generado correctamente.");
        } catch (IOException e) {
                // TODO Auto-generated catch block
            System.out.println("error en el archivo dot");    
        	e.printStackTrace();
                
        }
        
    }
    
    public static void generarSalida(String resultado, String archivo) throws IOException{
        File rutaResult = new File(System.getProperty("user.dir")+ "/" + archivo);
    	Writer writer = new BufferedWriter(new FileWriter(archivo));
    	writer.write(resultado);
    	writer.close();
    	System.out.println("Archivo generado de producciones correctamente.");
    }
    /*Metodo que hace el inverso del archivo para una lectura legible.*/
    public static void invertirArchivo(String archivo){
        String fichero = System.getProperty("user.dir")+ "/" + archivo;
        try {
            //Crea una pila donde guardara las lineas una a una leyendo archivo primeramente invertido.
            Stack<String> pila = new Stack<String>();
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                pila.push(linea); //Ingresa linea a linea a la pila.
            }
            fr.close(); //Cierra archivo para luego ser leido.
            File rutaResult = new File(fichero);
            BufferedWriter wr = new BufferedWriter(new FileWriter(rutaResult));
            String cadFinal = null;
            while(!pila.isEmpty()){
                wr.write(pila.pop()); //Lee la primera linea que en este caso es el orden correcto.
                wr.newLine(); //Se�ala que seguira otra linea para no cerrar el archivo solo con una.
                }
            wr.close(); //Cierra archivo final.
         }
         catch(Exception e) {
            System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e); //Error que ocurra.
         }
    }
}

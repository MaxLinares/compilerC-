package Scanner;
import java.io.File;


public class Generador {
	 public void generadorLexico() {
		    
	        jflex.Main.generate(new File(
	                "src" + File.separator + "Scanner" + File.separator + "lexer.flex"));
	    }
	  
	  public void generarParser(){
		 
		  String pathCUP = System.getProperty("user.dir") + "/src/Parser/Parser.cup";
			String[] asintactico = {"-destdir",System.getProperty("user.dir") + "/src/Parser/","-parser","Parser",pathCUP};
			try{
				java_cup.Main.main(asintactico);
				
				
			}catch(Exception ex){
				System.out.println(ex);
			} 
		
	  }
}

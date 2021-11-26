import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParcialFicheros {

	public static void main(String[] args) {
		File fileDatos =new File("datos.dat");
		File fileOperaciones=new File("operaciones.dat");
		
		//En datos.dat debe haber 
		//una cantidad par de números. Si no es así, se abortará el programa.

		
		int fileDatosLines=0;
		int primerNumeroFileDatos=0;//El primer número que encontramos en el archivo
		
		int fileOperacionesLines=0;
		
		//El contenido de operacionesDat solo puede 
		//recibir estas palabras linea a linea
		String suma="suma";
		String resta="resta";
		String multiplicacion="multiplicacion";
		//Para leer lineas del fichero datos.dat
		
		//Los ficheros deben existir, si no, System.exit(0)
		if(!fileDatos.exists()||!fileOperaciones.exists()) {
			System.exit(0);
		}
		//Una vez comprobado si existen validar fileDatos
		try {
			//Leo el fichero fileDatos por lineas hasta que no hay
			//fileDatosLines almacena el numero de lineas
			Scanner sc = new Scanner(new FileInputStream(fileDatos));
			String s="";
			while(sc.hasNext()) {	
				
				s=sc.nextLine();	
				if(fileDatosLines==0) {
					primerNumeroFileDatos=Integer.valueOf(s);
				}
				fileDatosLines++;
			}
			sc.close();
			System.out.println("Numero de lineas de fileDatos"+fileDatosLines);
			System.out.println("Primer numero :"+primerNumeroFileDatos);
			
			
			//Si ante la lectura del número 4 luego vemos que 
			//no tenemos 4 datos con los que hacer 
			//operaciones, entonces el programa acabará.
			
			if(fileDatosLines!=primerNumeroFileDatos+1) {
				System.out.println("Numero de datos no corresponde con el primer numero");
				System.exit(0);
			}
			
			
			
			//Comprueba si hay una cantidad de numeros par
			if(fileDatosLines%2==0) {
				System.out.println("datos impares");
				System.exit(0);
			}
			
			//si no hay nada en fileDatos termina el programa
			if(fileDatos.length()<=0) {
				System.out.println("fileDatos Vacio");
				System.exit(0);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//AQUI TERMINA DE VALIDAR fileDatos 
			
			
		
		//PASAMOS a validar fileOperaciones
		
			//el número de operaciones que hay en este archivo
			//debe ser siempre la mitad que 
			//números válidos hay en el otro.

			//Entonces validamos fileOperaciones. si no es valido termina el programa
		
		try {
			//si no hay nada en fileOperaciones termina el programa
			if(fileOperaciones.length()<=0) {
				System.out.println("fileOperaciones Vacio");
				System.exit(0);
			}
			
				Scanner sc= new Scanner(new FileInputStream(fileOperaciones));
				String s="";
				while(sc.hasNext()) {
					s=sc.nextLine();
					System.out.println(s);
					if(!(s.equals(suma)||s.equals(resta)||s.equals(multiplicacion))) {
						
						System.out.println("Operacion invalida");
						System.exit(0);
					}
					fileOperacionesLines++;
				}
				
				if(fileOperacionesLines!=	((fileDatosLines-1)/2))		{
					System.out.println("Numero de operaciones incorrecto.");
					System.exit(0);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
			System.out.println("Archivos validados ?");

		
		
		
		
		
		
		
		
			System.out.println("Archivos validados y fin del programa");
	}

}

package tema1;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class ClaseFile {
    
       static Scanner sc = new Scanner(System.in);
       static String guardarRuta="";
       
    public static void main(String[] args) {

        boolean fin = false;

        while (!fin) {
            System.out.println("1. Crear fichero y directorio\n"
                    + "2. Mostrar toda la información posible del fichero y/o directorio\n"
            		+ "3. Solicitar nombre o directorio del fichero\n"
                    + "4. Acceder a un directorio.\n"
                    + "5. Mostrar todos los archivos/subdirectorios de un directorio.\n"
                    + "6. Fin ");

            int opcion = sc.nextInt();
            sc.nextLine();//Lee una opcion despues del int
            switch (opcion) {
                case 1:
                	crearfichero();
                    break;
                case 2:
                	infoFichero();
                    break;
                case 3:
                	nombreFichero();
                    break;
                case 4:
                    break;
                case 5:

                    break;
                case 6:
                	sc.close();
                    break;
            }
        }
    }
    
    
    public static void crearfichero(){
    	
    	System.out.println("Introduce la ruta del fichero(Incluyendo el nombre del archivo)");
    	String rutaFichero = sc.nextLine();
        
        File fichero1 = new File(rutaFichero);
        
        try{
             if (fichero1.createNewFile()) {
            	 guardarRuta=rutaFichero;
                System.out.println("Fichero creado: correctamente" );
            } else {
                System.out.println("El fichero ya existe");
            }
        }
        catch(IOException  e){
                System.out.println("Error al crear el fichero: " + e.getMessage());

        }
    }

    public static void infoFichero() {
    	//Compruebo si la variable auxiliar no está vacia
    	if(!guardarRuta.isEmpty()) {
    		
    		//en un fichero almaceno la ruta completa del fichero creado anteriormente
    		File fichero = new File(guardarRuta);
    		
    		//Comprobamos los permisos de lectura
    		if (fichero.canRead()) {
    		    System.out.println(fichero.getName() + " tiene permisos de lectura");
    		}else {
    		    System.out.println(fichero.getName() + " NO tiene permisos de lectura");
    		}
    		//Comprobamos los permisos de escritura
    		if (fichero.canWrite()) {
    		    System.out.println(fichero.getName() + " tiene permisos de escritura");
    		}else {
    		    System.out.println(fichero.getName() + " NO tiene permisos de escritura");
    		}
    		//Comprobamos los permisos de ejecución
    		if (fichero.canExecute()) {
    		    System.out.println(fichero.getName() + " tiene permisos de ejecución");
    		}else {
    		    System.out.println(fichero.getName() + " NO tiene permisos de ejecución");
    		}
    		
    		System.out.println("El nombre del fichero creado se encuentra en " + fichero.getAbsolutePath());	

    	}
    }
    
    public static void nombreFichero(){
    	
    	//Compruebo si la variable auxiliar no está vacia
    	if(!guardarRuta.isEmpty()) {
    		
    		//en fichero almaceno la ruta completa(o datos) del fichero creado anteriormente
    		File fichero = new File(guardarRuta);
    		
    		System.out.println("El nombre del fichero creado es " + fichero.getName());	
    	}
    	
    	
    	
    }
}

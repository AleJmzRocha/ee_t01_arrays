package ArchivoArray;
import java.io.*;
import javax.swing.*;
/**
 * 
 * @author Alejandra Jiménez Rocha
 *Este proyecto consistirá en una clase que lea de un archivo, 
especificado como el primer parámetro de la clase 
lo siguiente:
ENTRADA:
6
1
2
3
4
5
6
SALIDA:
6
5
4
3
2
1
La primer linea es el numero de elementos y las siguientes son los elementos específicos.
Lo anterior meterlo en un array e imprimir en consola el mismo de manera descendente.

 */
public class Arrays {	
	static Integer contador; //cuenta el número de elementos para crear el arreglo
	static String[] array = new String[contador];
	
	//método para leer el archivo
	public static void leer(String nombre){
		File file = new File(nombre + ".txt");		
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			s = in.readLine();
//			while(s != null){
//				System.out.println(s);
//				s = in.readLine();
//			}
			while(s != null){
				contador++;
				s = in.readLine();
			}
			System.out.println(contador);
			in.close();
		}catch(FileNotFoundException e){
			System.out.println("El archivo " + file + " no existe.");
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
	
	//método que agrega los elementos del archivo al arreglo
	public static void agregarArreglo(String nombre){
		File file = new File(nombre + ".txt");		
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			s = in.readLine();
//			while(s != null){
//				System.out.println(s);
//				s = in.readLine();
//			}
			while(s != null){
				s = in.readLine();
				array[contador] = s;
				contador--;
			}
			in.close();
		}catch(FileNotFoundException e){
			System.out.println("El archivo " + file + " no existe.");
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
	
	//método que llama al ordenamiento e imprime el arreglo
	public static void arreglo(){		
		burbuja(array);
		for(int i = 1; i < array.length; i++)
			System.out.println(array[i]);
	}
	
	//método para ordenarlo de manera descendente
	private static void burbuja(String a[]){
	    String aux;
	    for(int x=0;x<a.length-1;x++)
	      for(int y=x+1;y<a.length;y++)
	       if(a[x].compareToIgnoreCase(a[y])>0){
	    	   aux=a[x];
	    	   a[x]=a[y];
	    	   a[y]=aux;
	        }
	    }

	public static void main(String[] args){		
		String nombre = JOptionPane.showInputDialog("Escriba el nombre del archivo (sin extensión):");
		leer(nombre);
		agregarArreglo(nombre);
		arreglo();
	}
}
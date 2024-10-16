import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Escriba el numero de la pelicula de Star Wars que quiere consultar: ");

        try {
            var numeroPelicula = Integer.valueOf(usuario.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroPelicula);
            System.out.println(pelicula);
            GeneradorArchivo generador = new GeneradorArchivo();
            generador.guardarJson(pelicula);

        } catch (NumberFormatException e){
            System.out.println("Numero no encontrado " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }


    }
}

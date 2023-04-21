package Menu;

import Resultados.ResultadosPronosticos;
import dao.DaoEquipoimpl;
import dao.DaoPartidoimpl;
import dao.DaoPronostiocoimpl;
import dao.DaoRondaimpl;
import interfaces.DaoEquipo;
import interfaces.DaoPartido;
import interfaces.DaoPronostico;
import interfaces.DaoRonda;
import org.example.Equipo;
import org.example.Partido;
import org.example.Pronostico;
import org.example.Ronda;

import java.util.List;
import java.util.Scanner;

public class MenuBaseDatos {
    public static void consultar() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("0")) {
            System.out.println(Colores.amarillo("Selecciona una opción:"));
            System.out.println(Colores.azulBrillante("1. Equipos y Descripciones"));
            System.out.println(Colores.cianBrillante("2. Resultados Partidos"));
            System.out.println(Colores.blancoBrillante("3. Pronosticos "));
            System.out.println(Colores.rojoBrillante("4. Mostrar resultados pronosticos"));
            System.out.println("5. Cambiar puntos por acierto");
            System.out.println(Colores.azul("0. Salir"));
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Equipos y Descripciones\n");
                    Equipo equipo = new Equipo();
                    DaoEquipo daoEquipo = new DaoEquipoimpl();
                    List<Equipo> listaEquipos = daoEquipo.listar();
                    for (Equipo e : listaEquipos) {
                        System.out.println(e.toString());
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    break;
                case "2":
                    System.out.println("Resultados Partidos");
                    Partido partido = new Partido();
                    DaoPartido daoPartido = new DaoPartidoimpl();
                    List<Partido> listaPartidos = daoPartido.listar();
                    for (Partido e : listaPartidos) {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println(e.toString());
                    }
                    break;
                case "3":
                    System.out.println("Pronosticos: ");
                    Pronostico pronostico = new Pronostico();
                    DaoPronostico daoPronostico = new DaoPronostiocoimpl();
                    List<Pronostico> listaPronosticos = daoPronostico.listar();
                    for (Pronostico e : listaPronosticos) {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println(e.toString());
                    }
                    break;
                case "4":
                    System.out.print(Colores.rojoBrillante("Resultados Pronosticos \n"));
                    ResultadosPronosticos result = new ResultadosPronosticos();
                    result.calcularPuntuacion();
                    break;
                case "5":
                    System.out.println(Colores.moradoBrillante("Ingrese los punto por acierto: \n"));
                    Scanner sc = new Scanner(System.in);
                    int puntos = sc.nextInt();
                    Ronda ronda = new Ronda();
                    ronda.setPuntos(puntos);
                    System.out.println(Colores.verdeBrillante("Cambio correcto"));
                    DaoRonda daoRonda = new DaoRondaimpl();
                    daoRonda.modificar(ronda);
                    break;
                case "0":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

        scanner.close();

    }
}



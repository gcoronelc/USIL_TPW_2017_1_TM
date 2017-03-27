package pe.henry.apppromedio.prueba;

import pe.henry.apppromedio.service.PromService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    int n1 = 20;
    int n2 = 15;
    int n3 = 13;
    int n4 = 12;
    int n5 = 9;
    // Proceso
    PromService service = new PromService();
    int menor = service.menor(n1, n2, n3, n4, n5);
    int prom = service.promediar(n1, n2, n3, n4, n5);

    // Reporte
    System.out.println("n1: " + n1);
    System.out.println("n2: " + n2);
    System.out.println("n3: " + n3);
    System.out.println("n4: " + n4);
    System.out.println("n5: " + n5);

    System.out.println("Promedio: " + prom);
    System.out.println("Menor: " + menor);
  }
}

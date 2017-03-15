package pe.egcc.appsuma.prueba;

import pe.egcc.appsuma.service.MateService;

public class Prueba01 {

  public static void main(String[] args) {
    // Variavles
    int n1, n2, suma;
    // Datos
    n1 = 60;
    n2 = 45;
    // Proceso
    MateService service = new MateService();
    suma = service.sumar(n1, n2);
    // Reporte
    System.out.println("n1: " + n1);
    System.out.println("n2: " + n2);
    System.out.println("Suma: " + suma);
  }
}

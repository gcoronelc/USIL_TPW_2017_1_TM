package service;

import javax.ejb.Stateless;

/* debemos escribir y  importar @Stateless */
@Stateless

public class PromService {

  public int prom(int n1, int n2, int n3) {
    // Variables
    int promedio, sum;
    // Proceso
    sum = n1 + n2 + n3;
    promedio = sum / 3;
    // Reporte
    return promedio;
  }

  public String condicion(int nota) {
    String cond = "Aprobado";
    if (nota < 13) {
      cond = "desaprobado";
    }
    return cond;
  }

}

package pe.egcc.appsuma.service;

import javax.ejb.Stateless;

/**
 *
 * @author Alumno
 */
@Stateless
public class MateService {

  public int sumar(int n1, int n2) {
    // Variables
    int suma;
    // Proceso
    suma = n1 + n2;
    // Reporte
    return suma;
  }

}

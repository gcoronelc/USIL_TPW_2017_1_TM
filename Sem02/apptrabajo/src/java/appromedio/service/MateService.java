/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appromedio.service;

/**
 *
 * @author TEFI
 */
public class MateService {
   
   public int calcMenor(int n1, int n2, int n3, int n4, int n5){
      // variables
      int menor = n1;
      // Proceso
      if (n2 < menor) {
         menor = n2;
      }
      if (n3 < menor) {
         menor = n3;
      }
      if (n4 < menor) {
         menor = n4;
      }
      if (n4 < menor) {
         menor = n5;
      }
      return menor;
   }

   public int calcPromedio(int n1, int n2, int n3, int n4, int n5) {
      // Variables
      int promedio, menor, suma ;
      // Proceso
      suma = n1 + n2 + n3 + n4 + n5;
      menor = calcMenor(n1, n2, n3, n4, n5);
      promedio = (suma - menor) / 4;
      // Reporte
      return promedio;
   }
}

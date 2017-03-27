package apppromedio.prueba;

import appromedio.service.MateService;

public class Prueba01 {

   public static void main(String[] args) {
      // Variavles
      int n1, n2, n3, n4, n5;
      int promedio, menor;
      
      // Datos
      n1 = 18;
      n2 = 18;
      n3 = 8;
      n4 = 15;
      n5 = 15;
      
      // Proceso
      MateService service = new MateService();
      promedio = service.calcPromedio(n1, n2, n3, n4, n5);
      menor = service.calcMenor(n1, n2, n3, n4, n5);
      
      // Reporte
      System.out.println("n1: " + n1);
      System.out.println("n2: " + n2);
      System.out.println("n3: " + n3);
      System.out.println("n4: " + n4);
      System.out.println("n5: " + n5);
      System.out.println("menor: " + menor);
      System.out.println("promedio: " + promedio);
   }

}

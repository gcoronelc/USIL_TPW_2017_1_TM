package pe.henry.apppromedio.service;

import javax.ejb.Stateless;

@Stateless
public class PromService {

  public int menor(int n1, int n2, int n3, int n4, int n5) {
    int min = n1;

    if (n2 < min) {
      min = n2;
    }
    if (n3 < min) {
      min = n3;
    }
    if (n4 < min) {
      min = n4;
    }
    if (n5 < min) {
      min = n5;
    }

    return min;
  }

  public int promediar(int n1, int n2, int n3, int n4, int n5) {
    int me = menor(n1, n2, n3, n4, n5);
    int pr = n1 + n2 + n3 + n4 + n5 - me;
    pr /= 4;
    return pr;
  }

}

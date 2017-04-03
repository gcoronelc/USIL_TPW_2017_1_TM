package pe.egcc.demo04;

import org.springframework.stereotype.Component;

@Component
public class AppService {
  
  public int sumar(int n1, int n2){
    return (n1 + n2);
  }
  
}

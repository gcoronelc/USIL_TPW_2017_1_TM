package pe.egcc.demo05;

import org.springframework.stereotype.Service;

@Service
public class AppService2 {
  
  public long factorial(int n){
    long f = 1;
    for(int i = 2; i <= n; i++){
      f *= i;
    }
    return f;
  }
  
}

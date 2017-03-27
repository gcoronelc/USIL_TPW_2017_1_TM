package pe.egcc.demo01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba01 {
  
  public static void main(String[] args) {
    
    String contexto = "/pe/egcc/demo01/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    AppService service;
    service = (AppService) beanFactory.getBean("appService");
    
    System.out.println("7 + 8 = " + service.sumar(7, 8));
    System.out.println("7 + 9 = " + service.sumar(7, 9));
    
  }
  
}

package pe.egcc.demo03;

public class AppController {

  private AppService service;

  public AppController(AppService service) {
    this.service = service;
  }

  public int sumar(int n1, int n2){
    return service.sumar(n1, n2);
  }

}

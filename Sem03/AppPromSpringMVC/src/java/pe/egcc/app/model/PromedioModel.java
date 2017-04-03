package pe.egcc.app.model;

public class PromedioModel {

  // input
  private int nota1;
  private int nota2;
  // output
  private int prom;
  private String cond;

  public PromedioModel() {
  }

  public PromedioModel(int nota1, int nota2) {
    this.nota1 = nota1;
    this.nota2 = nota2;
  }

  public int getNota1() {
    return nota1;
  }

  public void setNota1(int nota1) {
    this.nota1 = nota1;
  }

  public int getNota2() {
    return nota2;
  }

  public void setNota2(int nota2) {
    this.nota2 = nota2;
  }

  public int getProm() {
    return prom;
  }

  public void setProm(int prom) {
    this.prom = prom;
  }

  public String getCond() {
    return cond;
  }

  public void setCond(String cond) {
    this.cond = cond;
  }
  
  
}

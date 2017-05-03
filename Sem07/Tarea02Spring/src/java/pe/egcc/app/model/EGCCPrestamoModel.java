package pe.egcc.app.model;

public class EGCCPrestamoModel {

  private int mes;
  private double capitalInicial;
  private double capital;
  private double interes;
  private double total;

  public EGCCPrestamoModel() {
  }

  public EGCCPrestamoModel(int mes, double capitalInicial, double capital, double interes, double total) {
    this.mes = mes;
    this.capitalInicial = capitalInicial;
    this.capital = capital;
    this.interes = interes;
    this.total = total;
  }

  public double getCapitalInicial() {
    return capitalInicial;
  }

  public void setCapitalInicial(double capitalInicial) {
    this.capitalInicial = capitalInicial;
  }

  

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public double getCapital() {
    return capital;
  }

  public void setCapital(double capital) {
    this.capital = capital;
  }

  public double getInteres() {
    return interes;
  }

  public void setInteres(double interes) {
    this.interes = interes;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

}

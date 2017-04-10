package model;

public class PagosModel {

  //input
  private int horasDia;
  private int dias;
  private int pagoHora;

  //output 
  private int ingresos;
  private double renta;
  private double neto;

  public PagosModel() {

  }

  public PagosModel(int horasDia, int dias, int pagoHora) {
    this.horasDia = horasDia;
    this.dias = dias;
    this.pagoHora = pagoHora;
  }

  public int getHorasDia() {
    return horasDia;
  }

  public void setHorasDia(int horasDia) {
    this.horasDia = horasDia;
  }

  public int getDias() {
    return dias;
  }

  public void setDias(int dias) {
    this.dias = dias;
  }

  public int getPagoHora() {
    return pagoHora;
  }

  public void setPagoHora(int pagoHora) {
    this.pagoHora = pagoHora;
  }

  public int getIngresos() {
    return ingresos;
  }

  public void setIngresos(int ingresos) {
    this.ingresos = ingresos;
  }

  public double getRenta() {
    return renta;
  }

  public void setRenta(double renta) {
    this.renta = renta;
  }

  public double getNeto() {
    return neto;
  }

  public void setNeto(double neto) {
    this.neto = neto;
  }

}

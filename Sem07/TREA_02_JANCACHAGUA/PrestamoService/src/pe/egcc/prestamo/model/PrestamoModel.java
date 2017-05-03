package pe.egcc.prestamo.model;

public class PrestamoModel {

    private int mes;
    private double capital;
    private double interes;
    private double total;
    private double totalCuota;

    private double cuotaMensual;
    private double pagoAcapital;
    private double pagointeres;
//    private double tasaInteresMensual;
    private double interesAnual;
    private double montoTotalPagar;
    private double totalInteresPagar;
    
    public PrestamoModel() {
    }

//    public PrestamoModel(int mes, double capital, double cuotaMensual, double pagoAcapital, double pagointeres) {
//        this.mes = mes;
//        this.capital = capital;
//        this.cuotaMensual = cuotaMensual;
//        this.pagoAcapital = pagoAcapital;
//        this.pagointeres = pagointeres;
//    }
    
    public PrestamoModel(int mes, double capital, double interes, double total, double totalCuota) {
        this.mes = mes;
        this.capital = capital;
        this.interes = interes;
        this.total = total;
        this.totalCuota = totalCuota;
    }
    public double getTotalCuota() {
        return totalCuota;
    }

    public void setTotalCuota(double totalCuota) {
        this.totalCuota = totalCuota;
    }
    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public double getPagoAcapital() {
        return pagoAcapital;
    }

    public void setPagoAcapital(double pagoAcapital) {
        this.pagoAcapital = pagoAcapital;
    }

    public double getPagointeres() {
        return pagointeres;
    }

    public void setPagointeres(double pagointeres) {
        this.pagointeres = pagointeres;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    public double getMontoTotalPagar() {
        return montoTotalPagar;
    }

    public void setMontoTotalPagar(double montoTotalPagar) {
        this.montoTotalPagar = montoTotalPagar;
    }

    public double getTotalInteresPagar() {
        return totalInteresPagar;
    }

    public void setTotalInteresPagar(double totalInteresPagar) {
        this.totalInteresPagar = totalInteresPagar;
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

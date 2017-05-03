package pe.egcc.prestamo.service;

import java.util.ArrayList;
import java.util.List;
import pe.egcc.prestamo.model.PrestamoModel;


public class PrestamoService {


    
        public List<PrestamoModel> procPrestamo2(double capital, double porcInteres, int meses) {
        List<PrestamoModel> lista = new ArrayList<>();
       
        
               
        double porcInter=porcInteres/100;        
        double cuotaMensual=Math.round(((porcInter*capital)/(1-(Math.pow((1+porcInter),- meses))))); 

        
        double capitalCuota = redondear(capital / meses);
        for (int mes = 1; mes <= meses; mes++) {            
            if (mes == meses) {
                capitalCuota =redondear(capital);
            }
            double Pagointeres = Math.ceil((porcInteres/100)*capital);
            double PagoAcapital=Math.round(cuotaMensual-Pagointeres);           
            double DeudaInicial = redondear(capital);
           
            PrestamoModel bean = new PrestamoModel(mes,
                    DeudaInicial, Pagointeres, PagoAcapital,cuotaMensual);
            lista.add(bean);
            capital -= PagoAcapital ;
        }
        return lista;
    }
    private double redondear(double valor) {
        valor *= 100.0;
        valor = Math.round(valor);
        valor /= 100;
        return valor;
    }
    
    public PrestamoModel fijo(PrestamoModel model){
    
     // Proceso        
        double montopagar = (model.getCapital() * (model.getInteres() / 100))/ (1 - (Math.pow(1 + (model.getInteres() / 100), -model.getMes())));
        double montoTotalPagar = (montopagar * model.getMes());
        double totalinteres = montoTotalPagar- model.getCapital();
        double capitaltotal = model.getCapital();
        
        model.setCuotaMensual(montopagar);
        model.setMontoTotalPagar(montoTotalPagar);
        model.setCapital(capitaltotal);
        model.setPagointeres(totalinteres);
        
        return model;
    }
    
}

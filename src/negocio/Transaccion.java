/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.DatosTransaccion;
public class Transaccion {
    
    String numTransaccion;
    String _tipoTransaccion;
    String _numCuenta;
    String _saldo;
    
    public Transaccion(String saldoInicial) {
        this._saldo = saldoInicial;
    }
    public Transaccion(String numTransaccion, String _tipoTransaccion, String _numCuenta, String _saldo) {
        this.numTransaccion = numTransaccion;
        this._tipoTransaccion = _tipoTransaccion;
        this._numCuenta = _numCuenta;
        this._saldo = _saldo;
    }
   

    public String getNumTransaccion() {
        return numTransaccion;
    }

    public void setNumTransaccion(String numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public String getTipoTransaccion() {
        return _tipoTransaccion;
    }

    public void setTipoTransaccion(String _tipoTransaccion) {
        this._tipoTransaccion = _tipoTransaccion;
    }

    public String getNumCuenta() {
        return _numCuenta;
    }

    public void setNumCuenta(String _numCuenta) {
        this._numCuenta = _numCuenta;
    }

    public String getMonto() {
        return _saldo;
    }

    public void setMonto(String _monto) {
        this._saldo = _monto;
    }
    DatosTransaccion datosT = new DatosTransaccion();
//metodos
    
    public void agregarTransaccion(String numT, String tipoT, String numC, String saldo) 
    {
       datosT.agregarTransaccionXml(numT, tipoT, numC, saldo);
    }
   public void leerClientes()
   {
       datosT.leerTransaccionesXml();
   }
   
public boolean ValidarDuplicadosC(String numT, String tipoT, String numC, String saldo)
    {
        if (datosT.validarDuplicadosTransaccionesXml(numT, tipoT, numC, saldo))
                {
                   return false;
                   //no puede agregar
                }else 
                {
                 datosT.agregarTransaccionXml(numT, tipoT, numC, saldo);
                 return true;
                 //si puede agregar
                 
                }
    }

    public void ValidarDuplicado(String numT, String tipoT, String numC, String saldo)
    {
        datosT.validarDuplicadosTransaccionesXml( numT,  tipoT, numC,  saldo);
    }
        
    public boolean BuscarTransaccion(String num)
    {
        if (datosT.buscarTransaccionPorIdXml(num))
        {
             return true;
        }else{
            return false;
         }
     
     }
     
    public void BorrarTransaccion(String num)
    {
        datosT.eliminarTransaccionPorIdXml(num);
     
    }
    public void MostrarTransaccion()
    {
        datosT.mostrarContenidoXml();
    }
    
    
    public void ModificarTransaccion(String numT, String tipoT, String numC, String saldo)
    {
        datosT.modificarTransaccionXml(numT, tipoT, numC, saldo);
    }
    
    public void Depositar(Double monto)
    {
       Double saldoD=Double.valueOf(_saldo);
       saldoD+=monto;
       _saldo= saldoD.toString();
       ActualizarSaldo();
    }
    
    public boolean Retirar(Double monto)
    {
        Double saldoD=Double.valueOf(_saldo);
        
       if (monto>=saldoD)
       {
           saldoD-= monto;
           _saldo= saldoD.toString();
           ActualizarSaldo();
           return true;
       }
       return false;
    }
  
    public void ActualizarSaldo()
    {
        datosT.actualizarSaldo(numTransaccion, _saldo);
    }
    public boolean realizarTraslado(double monto, Transaccion cuentaDestino) {
        Double saldoD=Double.valueOf(_saldo);
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return false;
        }

        if (saldoD < monto) {
            System.out.println("Saldo insuficiente.");
            return false;
        }

        
        saldoD -= monto;
        _saldo= saldoD.toString();
        cuentaDestino.Depositar(monto);

 
        ActualizarSaldo();

        return true;
    }
}

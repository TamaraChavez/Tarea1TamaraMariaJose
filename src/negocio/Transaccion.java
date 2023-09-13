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
    Double _monto;
    
    public Transaccion(String numTransaccion, String _tipoTransaccion, String _numCuenta, Double _monto) {
        this.numTransaccion = numTransaccion;
        this._tipoTransaccion = _tipoTransaccion;
        this._numCuenta = _numCuenta;
        this._monto = _monto;
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

    public Double getMonto() {
        return _monto;
    }

    public void setMonto(Double _monto) {
        this._monto = _monto;
    }


    
}

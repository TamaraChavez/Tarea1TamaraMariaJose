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
    String _monto;
    
    public Transaccion(String numTransaccion, String _tipoTransaccion, String _numCuenta, String _monto) {
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

    public String getMonto() {
        return _monto;
    }

    public void setMonto(String _monto) {
        this._monto = _monto;
    }
    DatosTransaccion datosT = new DatosTransaccion();
//metodos
    
    public void agregarTransaccion(String numT, String tipoT, String numC, String monto) 
    {
       datosT.agregarTransaccionXml(numT, tipoT, numC, monto);
    }
   public void leerClientes()
   {
       datosT.leerTransaccionesXml();
   }
   
public boolean ValidarDuplicadosC(String numT, String tipoT, String numC, String monto)
    {
        if (datosT.validarDuplicadosTransaccionesXml(numT, tipoT, numC, monto))
                {
                   return false;
                   //no puede agregar
                }else 
                {
                 datosT.agregarTransaccionXml(numT, tipoT, numC, monto);
                 return true;
                 //si puede agregar
                 
                }
    }

    public void ValidarDuplicado(String numT, String tipoT, String numC, String monto)
    {
        datosT.validarDuplicadosTransaccionesXml( numT,  tipoT, numC,  monto);
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
    
    
    public void ModificarTransaccion(String numT, String tipoT, String numC, String monto)
    {
        datosT.modificarTransaccionXml(numT, tipoT, numC, monto);
    }
    
    
    
}

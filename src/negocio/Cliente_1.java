/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;
import datos.DatosClientes;

public class Cliente_1 {

    public static void agregar(String text, String text0, double parseDouble, long parseLong, Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String _identificacion;
    String _nombre;
    String _telefono;
    private Double _saldo;


   DatosClientes datosClientes= new DatosClientes();
   
//constructor
       public Cliente_1() {
    }
    public Cliente_1(String _identificacion, String _nombre, String _telefono) {
        this._identificacion = _identificacion;
        this._nombre = _nombre;
        this._telefono = _telefono;
    }
    
//propiedades getters

    public String getIdentificacion() {
        return _identificacion;
    }

    public void setIdentificacion(String _identificacion) {
        this._identificacion = _identificacion;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public DatosClientes getDatosClientes() {
        return datosClientes;
    }

    public void setDatosClientes(DatosClientes datosClientes) {
        this.datosClientes = datosClientes;
    }
    

//metodos
    public void agregarClientesC(String _identificacion, String _nombre, String _telefono) 
    {
       datosClientes.agregarClientesXml(_identificacion, _nombre, _telefono);
    }
    public void leerClientes()
    {
       datosClientes.leerClientesXml();
    }
   
    public boolean ValidarDuplicadosCliente(String _identificacion, String _nombre, String _telefono)
    {
        if (datosClientes.validarDuplicadosClientes(_nombre, _nombre, _telefono))
        {
            return false;
             //no puede agregar
        }else{
                 
                 datosClientes.agregarClientesXml(_identificacion, _nombre, _telefono);
                 return false;
                 //puede agregar
        }
    }

    public void ValidarDuplicado(String _identificacion, String _nombre, String _telefono)
    {
        datosClientes.validarDuplicadosClientes(_nombre, _nombre, _telefono);
    }
    public boolean BuscarId(String id)
    {
        if (datosClientes.buscarClientePorIdXml( id))
        {
             //existe
           return true;
        }else{
            //no existe
            return false;
        }
     
    }
     
    public void BorrarCliente(String id)
    {
        datosClientes.eliminarClientePorIdXml(id);
     
    }
    public void MostrarCliente()
    {
        datosClientes.mostrarContenidoXml();
    }
    
    
    public void ModificarCliente(String id, String _nombre, String _telefono)
    {
     datosClientes.modificarClienteXml(id, _nombre, _telefono);
    }

     public Double getSaldo() {
        return _saldo;
    }

    public void setSaldo(Double saldo) {
        this._saldo = saldo;
    }
    
 public Double depositar(Double deposito) {
       this._saldo = this._saldo + deposito;
       return this._saldo;
   }

    public Double retirar(double retiro) {
       if(this._saldo < retiro)
           return null;
       else
           return this._saldo = this._saldo - retiro;
   }

    public int getidentificacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getTarejeta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Tarjeta getTarjeta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTarjeta(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCelular(long parseLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    
    
    


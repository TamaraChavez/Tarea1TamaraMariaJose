/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;
import datos.DatosClientes;

public class Cliente {
    String _identificacion;
    String _nombre;
    String _telefono;

   DatosClientes datosClientes= new DatosClientes();
   
//constructor
       public Cliente() {
    }
    public Cliente(String _identificacion, String _nombre, String _telefono) {
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
    

    
}
    
    
    


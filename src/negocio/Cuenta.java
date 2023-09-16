
package negocio;
import datos.DatosCuenta;
public class Cuenta {

    String _numCuenta;
    String _tipoCuenta;
    String _propietario;

    public Cuenta() {
    }

    
    public Cuenta(String numCuenta, String tipoCuenta, String propietario) {
        this._numCuenta = numCuenta;
        this._tipoCuenta = tipoCuenta;
        this._propietario = propietario;
    }

    DatosCuenta datosCuenta = new DatosCuenta();
    public String getNumCuenta() {
        return _numCuenta;
    }

    public void setNumCuenta(String _numCuenta) {
        this._numCuenta = _numCuenta;
    }

    public String getTipoCuenta() {
        return _tipoCuenta;
    }

    public void setTipoCuenta(String _tipoCuenta) {
        this._tipoCuenta = _tipoCuenta;
    }

    public String getPropietario() {
        return _propietario;
    }

    public void setPropietario(String _propietario) {
        this._propietario = _propietario;
    }

    
    //metodos
    public void agregarCuentaC(String numCuenta, String tipoCuenta, String propietario) 
    {
        datosCuenta.agregarCuentaXml(numCuenta, tipoCuenta, propietario);
    }
    public void LeerCuentas()
    {
        datosCuenta.leerCuentasXml();
    }
    public void ValidarDuplicados(String numCuenta, String tipoCuenta, String propietario)
    {
        datosCuenta.validarDuplicadosCuentaXml(numCuenta, tipoCuenta, propietario);
    }
    public boolean ValidarDuplicadosCuenta(String _identificacion, String _nombre, String _telefono)
    {
        if (datosCuenta.validarDuplicadosCuentaXml(_nombre, _nombre, _telefono))
        {
            return false;
            //no puede agregar
                   
        }else{
            datosCuenta.agregarCuentaXml(_identificacion, _nombre, _telefono);
            //si pude agregar
            return true;
        }
    }
    public boolean BuscarId(String id)
    {
        if (datosCuenta.buscarCuentaPorIdXml( id))
        {
            //existe
            return true;
         }else{
             //no existe
            return false; 
         }
     
     }
    
    public void BorrarCuenta(String numCuenta)
    {
        datosCuenta.eliminarCuentaPorIdXml(numCuenta);
    }
    
    public void ModificarCuenta(String numCuenta, String tipoCuenta, String propietario)
    {
        datosCuenta.modificarCuentaXml(numCuenta, tipoCuenta, propietario);
    }
}

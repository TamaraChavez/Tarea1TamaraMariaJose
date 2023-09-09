
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

    
    public void agregarCuenta() {
       
        datosCuenta.agregarCuentaXml(_numCuenta, _tipoCuenta, _propietario);
    }
    public void agregarCuentaC(String numCuenta, String tipoCuenta, String propietario) {
        
        datosCuenta.agregarCuentaXml(numCuenta, tipoCuenta, propietario);
    }
    public void LeerCuentas()
    {
        datosCuenta.leerCuentasXml();
    }
    public void ValidarDuplicados()
    {
        datosCuenta.validarDuplicadosCuentaXml(_numCuenta, _tipoCuenta, _propietario);
    }
}

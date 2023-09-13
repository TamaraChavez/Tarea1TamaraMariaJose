/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;
import datos.DatosUsuario;
public class Usuario {
    
    String _tipoUsuario;
    String _nombreUsuario;
    String _contraseña;
    
        public Usuario(String nombre, String nomUsuario, String contraseña)
    {
        this._tipoUsuario= nombre;
        this._nombreUsuario=nomUsuario;
        this._contraseña=contraseña;
        
    }
    
    public String getNombre() {
        return _tipoUsuario;
    }

    public void setNombre(String nombre) {
        this._tipoUsuario = nombre;
    }

    public String getNombreUsuario() {
        return _nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this._nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return _contraseña;
    }

    public void setContraseña(String contraseña) {
        this._contraseña = contraseña;
    }
   
    DatosUsuario datosUsuario = new DatosUsuario();

    public void agregarUsuario() {
       
        datosUsuario.AgregarUsuariosXml(_nombreUsuario, _tipoUsuario, _contraseña);
    }

    public void LeerCuentas()
    {
        datosUsuario.leerUsuariosXml();
    }
    public void ValidarDuplicados()
    {
        datosUsuario.validarDuplicadosUsuariosXml(_nombreUsuario, _tipoUsuario, _contraseña);
    }
    
}

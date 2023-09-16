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
    //metodos
    public void agregarUsuario(String _nombreUsuario, String _tipoUsuario,String _contrasena) 
    {
        datosUsuario.AgregarUsuariosXml(_nombreUsuario, _tipoUsuario, _contrasena);
    }

    public void LeerUsuarios()
    {
        datosUsuario.leerUsuariosXml();
    }
    public void ValidarDuplicados(String _nombreUsuario, String _tipoUsuario,String _contrasena)
    {
        datosUsuario.validarDuplicadosUsuariosXml(_nombreUsuario, _tipoUsuario, _contrasena);
    }
    
    public boolean BuscaarTransaccion(String nom)
    {
        if (datosUsuario.buscarUsuariosPorNombreXml(nom))
        {
          return true; 
        }else{
            return false;
        }
    }
        
        public boolean ValidarDuplicadosUsuarios(String _nombreUsuario, String _tipoUsuario, String _contrasena)
        {
            if (datosUsuario.validarDuplicadosUsuariosXml(_nombreUsuario, _tipoUsuario, _contrasena))
            {
                return false;
            }else{
                datosUsuario.AgregarUsuariosXml(_nombreUsuario, _tipoUsuario, _contrasena);
                return true;
            }
        }
    public void borrarUsuario(String nom)
    {
        datosUsuario.eliminarUsuarioPorNombreXml(nom);
    }
    public void modificarUsuario(String _nombreUsuario, String _tipoUsuario, String _contrasena)
    {
        datosUsuario.modificarUsuarioXml(_nombreUsuario, _tipoUsuario, _contrasena);
    }
    
    public void MostrarUsuarios()
    {
        datosUsuario.mostrarContenidoXml();
    }
    
}

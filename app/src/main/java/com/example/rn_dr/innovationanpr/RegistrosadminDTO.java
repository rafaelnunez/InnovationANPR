package com.example.rn_dr.innovationanpr;

/**
 * Created by RN_DR on 23/09/2015.
 */
public class RegistrosadminDTO {

    private String Usuario;
    private String Password;
    private String Email;
    private String Roles_idRoles;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRoles_idRoles() {
        return Roles_idRoles;
    }

    public void setRoles_idRoles(String Roles_idRoles) {
        this.Roles_idRoles = Roles_idRoles;
    }
}

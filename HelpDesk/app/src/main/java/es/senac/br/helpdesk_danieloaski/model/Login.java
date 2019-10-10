package es.senac.br.helpdesk_danieloaski.model;

import java.util.Date;

public class Login {


    private Long id;
    private String login;
    private String password;

    public Login() {
    }

    public Login(Long id, String usuario, String senha) {
        this.id = id;
        this.login = usuario;
        this.password = senha;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

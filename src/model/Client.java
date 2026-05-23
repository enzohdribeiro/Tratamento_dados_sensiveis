package model;

import service.CpfValidator;
import service.EmailValidator;

public class Client {
    private final String name;
    private final String cpf;
    private final String email;

    public Client(String name, String cpf, String email) {
        if(! EmailValidator.isValid(email)) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        if(! CpfValidator.isValid(cpf)) {
            throw new IllegalArgumentException("Invalid CPF: " + cpf);
        }

        this.name = name;
        this.cpf = cpf;;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}

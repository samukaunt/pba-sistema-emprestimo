package br.ufg.pos.fswm.pba.emprestimos.cliente.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa a entidade de modelo de Pessoa.
 *
 * @author Bruno Nogueira de Oliveira
 * @date 18/10/17.
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private String profissao;
    private BigDecimal salario;
    private LocalDate nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}

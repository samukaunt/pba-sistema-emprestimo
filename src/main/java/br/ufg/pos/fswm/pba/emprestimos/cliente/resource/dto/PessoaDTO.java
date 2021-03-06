package br.ufg.pos.fswm.pba.emprestimos.cliente.resource.dto;

import br.ufg.pos.fswm.pba.emprestimos.cliente.modelo.Pessoa;
import br.ufg.pos.fswm.pba.emprestimos.cliente.modelo.Sexo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO que representa os dados de uma Pessoa no sistema
 *
 * @author Bruno Nogueira de Oliveira
 * @date 18/10/17.
 */
public class PessoaDTO {

    @NotBlank(message = "O nome da pessoa é obrigatório")
    private String nome;

    @CPF(message = "CPF inválido. Informe um CPF válido")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate nascimento;
    private String profissao;
    private BigDecimal salario;

    @NotBlank(message = "O sexo da pessoa é obrigatório")
    private String sexo;
    private String risco;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    /**
     * Classe interna respons&aacute;vel por realizar transforma&ccedil;&otilde;es na entidade {@link PessoaDTO}
     */
    public static final class PessoaDTOTransformer {

        public static final String DESEMPREGADO = "Desempregado";

        private PessoaDTOTransformer() {
            // classe utilitaria. Nao instanciavel
        }

        /**
         * Realiza a transformação de uma entidade {@link PessoaDTO} em {@link Pessoa}
         *
         * @param pessoaDto {@link PessoaDTO}
         * @return {@link Pessoa}
         */
        public static Pessoa criarEntidade(PessoaDTO pessoaDto) {
            final Pessoa pessoa = new Pessoa();
            pessoa.setNome(pessoaDto.getNome());
            pessoa.setCpf(pessoaDto.getCpf());

            String profissao = pessoaDto.getProfissao();
            if (StringUtils.isBlank(profissao)) {
                profissao = DESEMPREGADO;
            }
            pessoa.setProfissao(profissao);

            pessoa.setSalario(pessoaDto.getSalario());
            pessoa.setNascimento(pessoaDto.getNascimento());
            pessoa.setSexo(Sexo.fromNome(pessoaDto.getSexo()));
            return pessoa;
        }

        /**
         * Realiza a transformação de uma entidade {@link Pessoa} em uma {@link PessoaDTO}
         *
         * @param pessoa {@link Pessoa}
         * @return {@link PessoaDTO}
         */
        public static PessoaDTO criarDto(Pessoa pessoa) {
            final PessoaDTO dto = new PessoaDTO();
            dto.setNome(pessoa.getNome());
            dto.setCpf(pessoa.getCpf());
            dto.setProfissao(pessoa.getProfissao());
            dto.setSalario(pessoa.getSalario());
            dto.setNascimento(pessoa.getNascimento());
            dto.setSexo(pessoa.getSexo().name());
            dto.setRisco(pessoa.getRisco().name());
            return dto;
        }
    }
}

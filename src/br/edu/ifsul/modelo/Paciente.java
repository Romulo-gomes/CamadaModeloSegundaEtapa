/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author romulo
 */
@Entity
@Table(name="paciente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pac", sequenceName = "seq_pac_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pac", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @NotNull(message = "O data de nascimento deve ser informado")
    @Temporal(TemporalType.DATE) // conotação...
    @Column(name = "data_nascimento", nullable = false)
    private Calendar dataNascimento;
    
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Length(max = 15, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;
    
    @NotNull(message = "O sexo não pode ser nulo")
    @NotBlank(message = "O sexo não pode ser em branco")
    @Length(max = 10, message = "O sexo não pode ter mais que {max} caracteres")
    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;
    
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "historico",columnDefinition = "text")
    private String historico;
    
    @Min(value = 0, message = "O peso não pode ser negativo")
    @NotNull(message = "O peso total deve ser informado")
    @Column(name = "peso", nullable = false, columnDefinition = "decimal(8,2)")
    private Double peso;
    
    @Min(value = 0, message = "A altura não pode ser negativo")
    @NotNull(message = "A altura deve ser informado")
    @Column(name = "altura", nullable = false, columnDefinition = "decimal(8,2)")
    private Double altura;
    
    public Paciente(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

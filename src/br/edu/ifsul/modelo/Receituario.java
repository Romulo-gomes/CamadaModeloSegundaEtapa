/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author romulo
 */
@Entity
@Table(name = "receituario")
public class Receituario implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_rec", sequenceName = "seq_rec_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_rec", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A posologia não pode ser nulo")
    @NotBlank(message = "A posologia não pode ser em branco")
    @Column(name = "posologia", nullable = false, columnDefinition = "text")
    private String posologia;
    @NotNull(message = "A data deve ser informado")
    @Temporal(TemporalType.DATE) // conotação...
    @Column(name = "data", nullable = false)
    private Calendar validade;
    @NotNull(message = "A consulta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_receituario_consulta")    
    private Consulta consulta;
    @ManyToMany
    @JoinTable(name = "remedio",
        joinColumns = 
                @JoinColumn(name = "receituario", referencedColumnName = "id", nullable = false),inverseJoinColumns =
                @JoinColumn(name = "medicamento", referencedColumnName = "id", nullable = false))
    private List<Medicamento> remedio = new ArrayList<>();
    
    public Receituario(){
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public List<Medicamento> getRemedio() {
        return remedio;
    }

    public void setRemedio(List<Medicamento> remedio) {
        this.remedio = remedio;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="consulta")
public class Consulta implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data deve ser informado")
    @Temporal(TemporalType.DATE) // conotação...
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "A hora deve ser informado")
    @Temporal(TemporalType.DATE) // conotação...
    @Column(name = "hora", nullable = false)
    private Calendar hora;
    @NotNull(message = "A pré-consulta não pode ser nulo")
    @NotBlank(message = "A pré-consulta não pode ser em branco")
    @Column(name = "preconsulta", nullable = false, columnDefinition = "text")
    private String preconsulta;
    @NotNull(message = "A pós-consulta não pode ser nulo")
    @NotBlank(message = "A pós-consulta não pode ser em branco")
    @Column(name = "posconsulta", nullable = false)
    private String posconsulta;
    @NotNull(message = "O medico deve ser informada")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "crm", nullable = false)
    @ForeignKey(name = "fk_consulta_medico")
    private Medico medico;
    @NotNull(message = "O paciente deve ser informada")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_consulta_paciente")
    private Paciente paciente;
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Exame> exame = new ArrayList<>();
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Receituario> receituario = new ArrayList<>();
    
    public Consulta(){
        
    }

    public void adicionaExame(Exame obj){
        obj.setConsulta(this);
        this.exame.add(obj);
    }
    
    public void adicionaReceita(Receituario obj){
        obj.setConsulta(this);
        this.receituario.add(obj);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }

    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }
    
    
}

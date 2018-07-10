package com.glindia.condominio.model;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOCACOES")
@SequenceGenerator(name = "LOCACOES_SEQ", sequenceName = "LOCACOES_SEQ", allocationSize = 1)
public class Locacao implements Entidade {
    
    @Id
    @Column(name = "ID_LOCACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCACOES_SEQ")
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_LOCATARIO")
    private Locatario locatario;
    
    @NotNull
    @Column(name = "DT_LOCACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date locacao;
    
    @Column(name = "PERIODO_LOCACAO", length = 20)
    @NotNull(message = "{Locacao.periodo.NotNull}")
    @Size(min = 5, max = 20, message = "{Locacao.periodo.Size}")
    private String periodo;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_LOCACAO", precision = 15, scale = 5)
    private BigDecimal valorLocacao;

    @JoinColumn(name = "ID_LOCACAO")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocacaoItem> itens;
        
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Date getLocacao() {
        return locacao;
    }

    public void setLocacao(Date locacao) {
        this.locacao = locacao;
    }

     public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public BigDecimal getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(BigDecimal valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public List<LocacaoItem> getItens() {
        return itens;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.locatario);
        hash = 53 * hash + Objects.hashCode(this.locacao);
        hash = 53 * hash + Objects.hashCode(this.periodo);
        hash = 53 * hash + Objects.hashCode(this.valorLocacao);
        hash = 53 * hash + Objects.hashCode(this.itens);
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
        final Locacao other = (Locacao) obj;
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.locatario, other.locatario)) {
            return false;
        }
        
        if (!Objects.equals(this.locacao, other.locacao)) {
            return false;
        }
        if (!Objects.equals(this.valorLocacao, other.valorLocacao)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", locatario=" + locatario + ", locacao=" + locacao + ", periodo=" + periodo + ", valorLocacao=" + valorLocacao + ", itens=" + itens + '}';
    }
}    
    
   
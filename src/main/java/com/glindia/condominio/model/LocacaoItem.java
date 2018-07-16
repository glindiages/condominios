package com.glindia.condominio.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LOCACOES_ITENS")
@SequenceGenerator(name = "LOCACOES_ITENS_SEQ", sequenceName = "LOCACOES_ITENS_SEQ", allocationSize = 1)
public class LocacaoItem implements Entidade {
 
   @Id
    @Column(name = "ID_LOCACAO_ITEM")
    @GeneratedValue(generator = "LOCACOES_ITENS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_IMOVEL")
    private Imovel imovel;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_ITEM", precision = 15, scale = 5)
    private BigDecimal valorItem;
    
    @NotNull
    @Size(max = 255, message = "{LocacaoItem.descricaoitem.Size}")
    @Column(name = "DESCRICAOITEM", length = 255)
    private String descricaoItem;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.imovel);
        hash = 89 * hash + Objects.hashCode(this.valorItem);
        hash = 89 * hash + Objects.hashCode(this.descricaoItem);
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
        final LocacaoItem other = (LocacaoItem) obj;
        if (!Objects.equals(this.descricaoItem, other.descricaoItem)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.imovel, other.imovel)) {
            return false;
        }
           
        return Objects.equals(this.valorItem, other.valorItem);
    }

    @Override
    public String toString() {
        return "LocacaoItem{" + "id=" + id + ", imovel=" + imovel + ", valorItem=" + valorItem + ", descricaoItem=" + descricaoItem + '}';
    }
}


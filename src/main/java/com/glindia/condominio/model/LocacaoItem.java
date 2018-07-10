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
    @JoinColumn(name = "ID_LOCACAO")
    private Locacao locacao;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_ITEM", precision = 15, scale = 5)
    private BigDecimal valorItem;
    
    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_TOTAL", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocaco(Locacao locacao) {
        this.locacao = locacao;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.locacao);
        hash = 23 * hash + Objects.hashCode(this.valorItem);
        hash = 23 * hash + Objects.hashCode(this.valorTotal);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.locacao, other.locacao)) {
            return false;
        }
        if (!Objects.equals(this.valorItem, other.valorItem)) {
            return false;
        }
        
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoItem{" + "id=" + id + ", locacao=" + locacao + ", valorItem=" + valorItem + ", valorTotal=" + valorTotal + '}';
    }
    
}


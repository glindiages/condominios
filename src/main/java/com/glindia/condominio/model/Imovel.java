package com.glindia.condominio.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "IMOVEIS")
@SequenceGenerator(name = "IMOVEIS_SEQ", sequenceName = "IMOVEIS_SEQ", allocationSize = 1)
public class Imovel implements Entidade {
    
    @Id
    @Column(name = "ID_IMOVEL")
    @GeneratedValue(generator = "IMOVEIS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "{Imovel.codigo.NotNull}")
    @Size(min = 2, max = 20, message = "{Imovel.codigo.Size}")
    @Column(name = "CODIGO", length = 20, unique = true)
    private String codigo;
    
    @Size(max = 255, message = "{Imovel.descricao.Size}")
    @Column(name = "DESCRICAO", length = 255)
    private String descricao;
    
    @Size(max = 100, message = "{Imovel.endereco.Size}")
    @Column(name = "ENDERECO", length = 100)
    private String endereco; 
	
    @NotNull(message = "{Imovel.preco.NotNull}")
    @Digits(integer = 10, fraction = 5, message = "{Imovel.preco.Digits}")
    @Column(name = "PRECO", precision = 15, scale = 5)
    private BigDecimal preco;
    
    @NotNull(message = "{Imovel.metragem.NotNull}")
    @Digits(integer = 10, fraction = 5, message = "{Imovel.metragem.Digits}")
    @Column(name = "METRAGEM", precision = 15, scale = 5)
    private BigDecimal metragem;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getMetragem() {
        return metragem;
    }

    public void setMetragem(BigDecimal metragem) {
        this.metragem = metragem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.preco);
        hash = 79 * hash + Objects.hashCode(this.metragem);
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
        final Imovel other = (Imovel) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        
        return Objects.equals(this.metragem, other.metragem);
    }

    @Override
    public String toString() {
        return "Imovel{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", endereco=" + endereco + ", preco=" + preco + ", metragem=" + metragem + '}';
    }
    
}  
package br.com.i4business.money.domain.data.despesa;

import br.com.i4business.money.domain.data.Entity;
import br.com.i4business.money.domain.data.item.ItemID;
import br.com.i4business.money.domain.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class DespesaItem {

    private DespesaID despesa;
    private ItemID item;
    private BigDecimal valor;
    private Instant venceEm;

    public DespesaItem(DespesaID despesa, ItemID item, BigDecimal valor, Instant venceEm) {
        this.despesa = despesa;
        this.item = item;
        this.valor = valor;
        this.venceEm = venceEm;
    }

    public DespesaItem(ItemID item, BigDecimal valor, Instant venceEm) {
        this.item = item;
        this.valor = valor;
        this.venceEm = venceEm;
    }

    public static DespesaItem com(
            final DespesaID despesaID,
            final ItemID item,
            final BigDecimal valor,
            final Instant venceEm
    ) {
        return new DespesaItem(
                despesaID,
                item,
                valor,
                venceEm
        );
    }

    public DespesaID getDespesa() {
        return despesa;
    }

    public ItemID getItem() {
        return item;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public Instant getVenceEm() {
        return venceEm;
    }
}

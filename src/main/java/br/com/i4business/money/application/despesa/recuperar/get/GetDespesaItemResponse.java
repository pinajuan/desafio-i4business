package br.com.i4business.money.application.despesa.recuperar.get;

import br.com.i4business.money.domain.data.despesa.DespesaID;
import br.com.i4business.money.domain.data.despesa.DespesaItem;
import br.com.i4business.money.domain.data.item.ItemID;

import java.math.BigDecimal;
import java.time.Instant;

public record GetDespesaItemResponse(
        DespesaID despesaId,
        ItemID itemId,
        BigDecimal valor,
        Instant venceEm
) {
    public static GetDespesaItemResponse fromDespesaItem(final DespesaItem despesaItem) {
        return new GetDespesaItemResponse(
                despesaItem.getDespesa(),
                despesaItem.getItem(),
                despesaItem.getValor(),
                despesaItem.getVenceEm()
        );
    }
}

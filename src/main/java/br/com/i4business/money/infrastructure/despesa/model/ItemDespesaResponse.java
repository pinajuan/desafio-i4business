package br.com.i4business.money.infrastructure.despesa.model;

import br.com.i4business.money.application.despesa.recuperar.get.GetDespesaItemResponse;
import br.com.i4business.money.domain.data.despesa.DespesaID;
import br.com.i4business.money.domain.data.despesa.DespesaItem;
import br.com.i4business.money.domain.data.item.ItemID;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

public record ItemDespesaResponse(
        @JsonProperty("item_id") ItemID itemId,
        @JsonProperty("valor") BigDecimal valor,
        @JsonProperty("vence_em") Instant venceEm
) {
    public static ItemDespesaResponse fromGetDespesaItemResponse(final GetDespesaItemResponse out) {
        return new ItemDespesaResponse(
                out.itemId(),
                out.valor(),
                out.venceEm()
        );
    }
}

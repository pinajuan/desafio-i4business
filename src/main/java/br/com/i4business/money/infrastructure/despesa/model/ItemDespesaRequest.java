package br.com.i4business.money.infrastructure.despesa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.core.util.Json;

import java.math.BigDecimal;
import java.time.Instant;

public record ItemDespesaRequest(
        @JsonProperty("item_id") String id,
        @JsonProperty("valor") BigDecimal valor,
        @JsonProperty("vence_em")Instant venceEm
        ) {
}

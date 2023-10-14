package br.com.i4business.money.infrastructure.categoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public record CategoriaResponse(
        @JsonProperty("id") String id,
        @JsonProperty("nome") String nome,
        @JsonProperty("descricao") String descricao,
        @JsonProperty("is_ativo") Boolean ativo,
        @JsonProperty("criado_em") Instant criadoEm,
        @JsonProperty("alterado_em") Instant alteradoEm,
        @JsonProperty("deletado_em") Instant deletadoEm,
        @JsonProperty("itens_id") List<String> itens
        ) {
}

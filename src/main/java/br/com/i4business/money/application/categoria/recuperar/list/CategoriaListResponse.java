package br.com.i4business.money.application.categoria.recuperar.list;

import br.com.i4business.money.domain.data.categoria.Categoria;
import br.com.i4business.money.domain.data.categoria.CategoriaID;
import br.com.i4business.money.domain.data.item.ItemID;

import java.time.Instant;
import java.util.List;

public record CategoriaListResponse(
        CategoriaID id,
        String nome,
        String descricao,
        boolean isAtivo,
        Instant criadoEm,
        Instant atualizadoEm,
        Instant deletadoEm,
        List<String> itens
) {
    public static CategoriaListResponse de(final Categoria aCategorIA) {
        return new CategoriaListResponse(
                aCategorIA.getId(),
                aCategorIA.getNome(),
                aCategorIA.getDescricao(),
                aCategorIA.isAtivo(),
                aCategorIA.getCriadoEm(),
                aCategorIA.getAlteradoEm(),
                aCategorIA.getDeletadoEm(),
                aCategorIA.getItens().stream().map(ItemID::getValue).toList()
        );
    }
}

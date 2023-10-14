package br.com.i4business.money.application.despesa.atualizar;

import java.math.BigDecimal;
import java.time.Instant;

public record AtualizarDespesaItemCommand(
        String id,
        BigDecimal valor,
        Instant venceEm
) {
}

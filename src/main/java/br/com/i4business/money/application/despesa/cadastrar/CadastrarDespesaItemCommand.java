package br.com.i4business.money.application.despesa.cadastrar;

import java.math.BigDecimal;
import java.time.Instant;

public record CadastrarDespesaItemCommand(
        String id,
        BigDecimal valor,
        Instant venceEm
) {
}

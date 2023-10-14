package br.com.i4business.money.domain.data.despesa;

import br.com.i4business.money.domain.UnitTest;
import br.com.i4business.money.domain.data.categoria.Categoria;
import br.com.i4business.money.domain.data.item.ItemID;
import br.com.i4business.money.domain.exception.DomainException;
import br.com.i4business.money.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DespeTest extends UnitTest {

    @Test
    public void dadoParametrosValidos_quandoChamarNovaDespesa_entaoInstancieADespesa() {
        final var expectedName = "Aluguel";
        final var expectedIsActive = true;
        final List<DespesaItem> expectedDespesaItens = new ArrayList<>();
        final var expectedDespesa = "123";
        final var expectedItem = "1234";
        final var expetecdValue = new BigDecimal("900.00");

        expectedDespesaItens.add(new DespesaItem(new DespesaID(expectedDespesa), new ItemID(expectedItem), expetecdValue, null));

        final var actualDespesa = Despesa.newDespesa(expectedName, expectedIsActive, expectedDespesaItens);

        Assertions.assertNotNull(actualDespesa);
        Assertions.assertNotNull(actualDespesa.getId());
        Assertions.assertEquals(expectedName, actualDespesa.getNome());
        Assertions.assertEquals(expectedIsActive, actualDespesa.isAtivo());
        Assertions.assertNotNull(expetecdValue);
        Assertions.assertNotEquals(expetecdValue.compareTo(BigDecimal.ZERO), 0);
        Assertions.assertNotNull(actualDespesa.getCriadoEm());
        Assertions.assertNotNull(actualDespesa.getAlteradoEm());
        Assertions.assertNull(actualDespesa.getDeletadoEm());
    }


    @Test
    public void dadoNomeNull_quandoChamarNovaDespesaEValidar_entaoDeveSerLancadoUmError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'nome' should not be null";
        final var expectedIsActive = true;

        final var actualDespesa = Despesa.newDespesa(expectedName, expectedIsActive, new ArrayList<>());

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualDespesa.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void dadoNomeVazio_quandoChamarNovaDespesaEValidar_entaoDeveSerLancadoUmError() {
        final var expectedName = "  ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'nome' should not be empty";
        final var expectedIsActive = true;

        final var actualDespesa =
                Despesa.newDespesa(expectedName, expectedIsActive, new ArrayList<>());

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualDespesa.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

}

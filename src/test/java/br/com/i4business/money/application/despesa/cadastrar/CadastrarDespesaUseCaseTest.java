package br.com.i4business.money.application.despesa.cadastrar;

import br.com.i4business.money.application.UseCaseTest;
import br.com.i4business.money.domain.data.despesa.DespesaGateway;
import br.com.i4business.money.domain.data.item.ItemGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class CadastrarDespesaUseCaseTest extends UseCaseTest {

    @InjectMocks
    private DefaultCadastrarDespesaUseCase useCase;
    @Mock
    private DespesaGateway despesaGateway;
    @Mock
    private ItemGateway itemGateway;
    @Override
    protected List<Object> getMocks() {
        return List.of(despesaGateway, itemGateway);
    }

    // 1. Teste do caminho feliz
    // 2. Teste passando uma propriedade inválida (name)
    // 3. Teste criando uma categoria inativa
    // 4. Teste simulando um erro generico vindo do gateway

    @Test
    public void givenAValidCommand_whenCallsCreateDespesa_shouldReturnDespesaId() {
        final var expectedName = "Aluguel";
        final var expectedIsActive = true;

        final var aCommand = CadastrarDespesaCommand.com(expectedName, new ArrayList<>(), expectedIsActive);

        when(despesaGateway.cadastrar(any())).thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(despesaGateway, times(1)).cadastrar(argThat(aCategory ->
                Objects.equals(expectedName, aCategory.getNome())
                        && Objects.equals(expectedIsActive, aCategory.isAtivo())
                        && Objects.nonNull(aCategory.getId())
                        && Objects.nonNull(aCategory.getCriadoEm())
                        && Objects.nonNull(aCategory.getAlteradoEm())
                        && Objects.isNull(aCategory.getDeletadoEm())
        ));
    }


}

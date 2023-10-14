package br.com.i4business.money.domain.data.despesa;

import br.com.i4business.money.domain.exception.DataException;
import br.com.i4business.money.domain.validation.Error;
import br.com.i4business.money.domain.validation.ValidationHandler;
import br.com.i4business.money.domain.validation.Validator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaValidator extends Validator {
    public static final int NAME_MAX_LENGTH = 100;
    public static final int NAME_MIN_LENGTH = 1;
    private final Despesa despesa;
    protected DespesaValidator(ValidationHandler aHandler, Despesa despesa) {
        super(aHandler);
        this.despesa = despesa;
    }

    @Override
    public void validate() {
    }

    private void checkNameConstraints() {
        final var name = this.despesa.getNome();
        if (name == null) {
            this.validationHandler().append(new Error("'nome' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'nome' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'nome' must be between 1 and 100 characters"));
        }
    }

    private void checkDespesaItensConstraints() {
        final var despesaItens = this.despesa.getItens();
        if (despesaItens == null) {
            this.validationHandler().append(new Error("'nome' should not be null"));
            return;
        }

        if (despesaItens.isEmpty()) {
            this.validationHandler().append(new Error("'nome' should not be empty"));
        }

    }
    
    private void checkVencimentoConstrains(DespesaItem despesaItem) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataVencimento = LocalDate.from(despesaItem.getVenceEm());

        if (dataVencimento.isBefore(hoje)) {
            throw new DataException("'date' must not be before today's date");
        }

        if (despesaItem.getVenceEm() == null) {
            this.validationHandler().append(new Error("'data' should not be null"));
            return;
        }

        if (despesaItem.getVenceEm().toString().isBlank()) {
            this.validationHandler().append(new Error("'data' should not be empty"));
        }
    }

    private void checkValorConstrains(DespesaItem despesaItem) {

        if (despesaItem.getValor().compareTo(BigDecimal.ZERO) == 0) {
            this.validationHandler().append(new Error("'value' must not be equal to zero"));
            return;
        }

        if (despesaItem.getValor().compareTo(BigDecimal.ZERO) < 0) {
            this.validationHandler().append(new Error("'value' must not be less than zero"));
            return;
        }

        if (despesaItem.getValor() == null) {
            this.validationHandler().append(new Error("'value' should not be null"));
        }

    }

}
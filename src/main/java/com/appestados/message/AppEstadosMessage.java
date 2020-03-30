package com.appestados.message;


import com.appestados.exception.BadRequestException;
import com.appestados.exception.BusinessException;

public enum AppEstadosMessage {
    CIDADE_INVALIDA("Dados de cidade inválidos"),
    POPULACAO_INVALIDA("A população é informação obrigatória"),
    NOME_INVALIDO("Nome é um campo obrigatório"),
    ESTADO_INVALIDO("Id do estado é um campo obrigatório"),
    CIDADE_JA_EXISTENTE("Já existe uma cidade com o nome %s para esse estado"),
    CIDADE_NAO_EXCLUIR("Não é permitida a exclusão de cidades do estado  %s"),
    ERRO_SALVAR_CIDADE("Erro ao salvar cidade (%s)"),
    ERRO_EXCLUIR_CIDADE("Erro ao salvar cidade (%s)"),
    CIDADE_INEXISTENTE("Cidade com o ID (%s), não encontrada"),
    ESTADO_INEXISTENTE("Estado com o ID (%s), não encontrado"),

    ERRO_LISTAR_CIDADE("Erro ao consultar cidades (%s)");
    private String message;

    AppEstadosMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return String.format("CONTAS-%04d", this.ordinal() + 1);
    }



    public static BusinessException business(AppEstadosMessage inventoryMessages, Object... args) {
        return new BusinessException(String.format(inventoryMessages.getMessage(), args),
                inventoryMessages.getCode());
    }

    public static BusinessException business(AppEstadosMessage inventoryMessages) {
        return new BusinessException(inventoryMessages.getMessage(), inventoryMessages.getCode());
    }


    public static BadRequestException badRequest(AppEstadosMessage inventoryMessages, Object... args) {
        return new BadRequestException(String.format(inventoryMessages.getMessage(), args),
                inventoryMessages.getCode());
    }

    public static BadRequestException badRequest(AppEstadosMessage inventoryMessages) {
        return new BadRequestException(inventoryMessages.getMessage(), inventoryMessages.getCode());
    }

}

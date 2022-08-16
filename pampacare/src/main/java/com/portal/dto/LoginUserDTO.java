package com.portal.dto;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String id;
    private String nome;
    private String email;
    private String password;
    private String profissao;
    private String instituicao;
    private String areaPesquisa;
    private String funcao;
}
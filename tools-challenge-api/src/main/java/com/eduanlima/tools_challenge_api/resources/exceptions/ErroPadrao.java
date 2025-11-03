package com.eduanlima.tools_challenge_api.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Instant dataHora;
    private Integer status;
    private String erro;
    private String mensagem;
    private String caminho;
}

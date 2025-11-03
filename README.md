
# API de Gerenciamento de Pagamentos
API para simulação de operações com cartão de crédito.



## Tecnologias Utilizadas

-   Java 17 
-   Spring Boot 3.4.11    
-   Gradle 
-   Lombok
-   JUnit
    


## Funcionalidades

✅ Solicitar um novo pagamento;
✅ Consultar todos os pagamentos ou estornos;
✅ Buscar transação por ID;
✅ Solicitar estorno de um pagamento;


##  Estrutura dos Endpoints


|   Método   | Endpoint        | Descrição                     | Corpo (JSON)                                                                 |
| :--------: | :-------------- | :---------------------------- | :--------------------------------------------------------------------------- |
|  **PUT**  | `/pagamento`      | Solicita um novo pagamento          | [Ver exemplo JSON](#exemplo-de-requisição) |
|   **GET**  | `/pagamento`      | Lista todos os pagamentos        | —                                                                            |
|   **GET**  | `/pagamento/{id}` | Retorna os dados de um pagamento específico através do id   | —                                                                            |
|   **PUT**  | `/estorno/{id}` | Solicita o estorno de um pagamento através de seu id | —    |
| **GET** | `/estorno` | Lista todas as solicitações de estorno             | —                                                                            |
| **GET** | `/estorno/{id}` | Retorna o registro específico de uma solicitação de estorno             | —                                                                            |


###  Exemplo de Requisição

```json
{
  "transacao": {
		"id": "8585773000969898002",
        "cartao": "5555****0000",
        "descricao": {
           "valor": "1000.00",
           "estabelecimento": "PetShop Mundo cão"
         },
       "formaPagamento": {
       "tipo": "AVISTA",
       "parcelas": 1
      }
   }
}
```
## Como Executar o Projeto
Pré-requisitos: 
* Java instalado (mínimo 17)
### No windows
1. Clonar o repositório:
`git clone https://github.com/eduanlima/ToolsChallenge` 
2. Na pasta raíz (`\tools-challenge-api`) executar:
`./gradlew build bootRun`
4. Acessar a API:
	A aplicação ficará disponível em:
`http://localhost:8080` 

### No linux

1. Clonar o repositório:
`git clone https://github.com/eduanlima/ToolsChallenge` 
2. Na pasta raíz (`\tools-challenge-api`), permitir a execução ao Gradle Wrapper:
 `chmod +x gradlew`
3. Executar:
`./gradlew build`
`java -jar build/libs/tools-challenge-api-0.0.1-SNAPSHOT.jar`
5. Acessar a API:
	A aplicação ficará disponível em:
`http://localhost:8080` 


##  Testando a API

É possível testar a API utilizando Postman, Insomnia, Thunder Client ou qualquer outra aplicação de requisições HTTP para enviar e validar os endpoints.
    
### Simuladores de cartões de crédito disponíveis

Para simular solicitações de pagamento, deve ser utilizado um dos cartões de crédito listados abaixo:

|   Número do cartão   | Saldo inicial                                                                   |
| :------------------------------: | :-------------------- |
|  1111****0000  | 1000.00      |
|  2222****0000  | 2000.00      | 
|  3333****0000  | 3000.00 |                                                         
|  4444****0000  | 4000.00 | 
|  5555****0000  | 5000.00 |                                                                                                                                        


O simulador de cartões de crédito é inicializado assim que a aplicação é executada, permitindo testes em diferentes cenários de acordo com o saldo disponibilizado para cada cartão. Esta função foi criada apenas com o objetivo de simular o processo de maneira que mais se assemelha a um cenário real.

Optou-se também por manter o sigilo dos números de cartão de crédito ainda na solicitação de pagamento, pois, em sistemas bancários reais devem ser utilizadas ferramentas para criptografar e descriptografar esse tipo de informação.


#### Tipos de Forma de Pagamento (Enum)

| Tipo                | Descrição                       |
|---------------------|----------------------------------|
| `AVISTA`            | Pagamento à vista                |
| `PARCELADO_LOJA`    | Parcelamento feito pela loja     |
| `PARCELADO_EMISSOR` | Parcelamento feito pelo emissor  |

##  Estrutura do projeto

O projeto foi desenvolvido utilizando Spring Boot para a criação da API RESTful. A estrutura do projeto foi organizada de forma a facilitar a manutenção e implementação de novas funcionalidades na API e tornar o sistema escalável utilizando conceitos do paradigma de Programação Orientada a Objetos. 

As principais entidades desenvolvidas na aplicação são `Pagamento` e `Estorno`, que por sua vez utilizam `Descricao` e `FormaPagamento` e derivam da classe base `Transacao`. Todas essas entidades constam na pasta `entities`. Optou-se por utilizar Estorno e Pagamento em entidades separadas para manter o histórico contábil completo na aplicação. Apenas atualizar o status do registro de pagamento de `AUTORIZADO` para `CANCELADO` não manteria o detalhamento da operação original e o respectivo evento de estorno, o que comprometeria a rastreabilidade das transações.

Os dados de pagamento são salvos em tempo de execução. E este gerenciamento é feito pela classe `LocalStorage` na pasta `repositories`. 

A camada de acesso a dados foi projetada seguindo os padrões necessários para persistência em banco de dados. No entanto, para simplificar a execução da aplicação e facilitar testes, os dados são salvos em tempo de execução. Este gerenciamento é feito pela classe `LocalStorage`, localizada na pasta `repositories`. 

As rotas da API foram desenvolvidas e organizadas dentro da pasta `resources`. Foi utilizado o método PUT para gerar pagamentos e estornos garantindo a idempotência das operações. 

As regras de negócio da aplicação foram desenvolvidas dentro da pasta `services`.


## Autor

**Eduan Júnior de Lima**  
💼 [LinkedIn](https://www.linkedin.com/in/eduan-junior-de-lima-389a94115/) 


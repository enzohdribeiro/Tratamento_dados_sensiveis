Tratamento de dados sensíveis

Este projeto simula um sistema de tratamento de logs de servidor, aplicando conceitos avançados de Programação Orientada a Objetos e manipulação de texto de alta performance para ocultar dados sensíveis (como CPF e E-mail), garantindo a conformidade com as diretrizes da LGPD (Lei Geral de Proteção de Dados).

## Tecnologias e Ferramentas Aplicadas

*   **Java OpenJDK**
*   **Expressões Regulares (Regex):** Criação de padrões complexos com as classes `Pattern` e `Matcher` para varredura de textos brutos.
*   **Manipulação Estruturada de Texto:** Uso de `StringBuilder` para otimização de memória e processamento performático de strings.

---

## Conceitos e Conhecimentos Demonstrados

### 1. Design Defensivo e Integridade do Objeto
Validação rigorosa de dados diretamente no construtor da classe `Client`. O objeto é "blindado" contra estados inválidos; caso um e-mail ou CPF esteja fora do padrão, a aplicação interrompe o nascimento do objeto lançando uma `IllegalArgumentException`.

### 2. Grupos de Captura em Regex
Uso avançado de tokens e parênteses de captura (`$1`, `$2`) para mascarar apenas o "miolo" das informações confidenciais, preservando os caracteres estruturais das pontas para fins de legibilidade do log sem expor a identidade do usuário:
*   `123.456.789-00` ➡️ `123.***.***-00`
*   `Ana@gmail.com` ➡️ `A*****a@gmail.com`

### 3. Métodos Utilitários Estáticos (Static)
Arquitetura de classes de serviço (`EmailValidator`, `CpfValidator`, `SensitiveDataTreat`) focada em stateless (sem estado), utilizando métodos estáticos para executar funções puras de validação e tratamento de forma direta e limpa.

### 4. Processamento de Texto em Cadeia (Streaming de Strings)
Encadeamento lógico de buffers de memória através do método `toString()`, permitindo que o resultado do mascaramento do primeiro dado (CPF) sirva como entrada imediata para o tratamento do próximo dado (E-mail).

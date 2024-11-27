# Mockito

O **Mockito** é um framework de testes usado para **simular instâncias de classes e comportamentos de métodos**. Ele permite criar dependências "mockadas", facilitando o isolamento de partes específicas do código durante os testes.

## Principais Comandos e Funcionalidades

### 1. Criar um Mock

Para simular uma instância de classe e seus métodos:

```java
@Mock
private MinhaClasse minhaClasseMock;
```

Ou diretamente no código:

```java
MinhaClasse minhaClasseMock = Mockito.mock(MinhaClasse.class);
```

### 2. Configurar Comportamento com `when`

Para definir o retorno esperado de um método mockado:

```java
when(minhaClasseMock.meuMetodo()).thenReturn("Retorno Esperado");
```

Exemplo com argumento genérico:

```java
when(minhaClasseMock.meuMetodo(anyString())).thenReturn("Retorno para qualquer String");
```

### 3. Verificar Interações com `verify`

Para confirmar se um método foi chamado, com quais parâmetros e quantas vezes:

```java
verify(minhaClasseMock, times(1)).meuMetodo("Parametro");
```

Outros exemplos:
- **Nunca chamado**:
  ```java
  verify(minhaClasseMock, never()).outroMetodo();
  ```
- **Chamado pelo menos uma vez**:
  ```java
  verify(minhaClasseMock, atLeastOnce()).meuMetodo("Parametro");
  ```

### 4. Criar um Spy

Para testar métodos reais da classe, preservando parte do comportamento original:

```java
@Spy
private MinhaClasse minhaClasseSpy;
```

Ou diretamente no código:

```java
MinhaClasse minhaClasseSpy = Mockito.spy(new MinhaClasse());
```

Você pode sobrescrever métodos específicos:

```java
doReturn("Valor Sobrescrito").when(minhaClasseSpy).metodoReal();
```

### 5. Usar `@InjectMocks`

Para criar uma instância real da classe a ser testada e injetar automaticamente dependências mockadas:

```java
@InjectMocks
private MinhaClasse classeTestada;
```

Isso elimina a necessidade de inicializar manualmente as dependências.

### 6. Utilizar Matchers

Para verificar argumentos de forma flexível:

```java
when(minhaClasseMock.meuMetodo(anyString())).thenReturn("Retorno");
```

Exemplos de matchers disponíveis:
- **`any()`**: aceita qualquer valor.
- **`anyString()`**: aceita qualquer string.
- **`anyInt()`**: aceita qualquer número inteiro.

## Exemplo Completo

```java
@RunWith(MockitoJUnitRunner.class)
public class MinhaClasseTest {

    @Mock
    private DependenciaMockada dependencia;

    @InjectMocks
    private MinhaClasse classeTestada;

    @Test
    public void testMetodo() {
        // Configurar comportamento
        when(dependencia.metodoDependencia()).thenReturn("Mockado");

        // Executar o método
        String resultado = classeTestada.metodo();

        // Verificar retorno
        assertEquals("Mockado", resultado);

        // Verificar interações
        verify(dependencia, times(1)).metodoDependencia();
    }
}
```
## O que é um Mock?

Um **mock** é um objeto que simula o comportamento de um objeto real.

Diferentemente de **stubs**, os mocks:
- **Podem ser criados dinamicamente em tempo de execução** (runtime), o que os torna mais flexíveis e fáceis de usar.
- **Oferecem funcionalidades adicionais**, como verificar se métodos foram chamados, com quais argumentos e quantas vezes.

### Benefícios dos Mocks em Relação aos Stubs:
1. **Criação dinâmica:** Não é necessário implementar manualmente cada método, reduzindo o esforço de manutenção.
2. **Verificação de interações:** Você pode monitorar como os métodos são chamados durante o teste, o que facilita a validação do comportamento do código.
3. **Maior flexibilidade:** Permite simular diferentes cenários e comportamentos sem alterar o código original.

Por exemplo, com o Mockito, você pode criar um mock e configurar seu comportamento em tempo de execução:

```java
MinhaClasse minhaClasseMock = Mockito.mock(MinhaClasse.class);

// Configurar comportamento do mock
when(minhaClasseMock.meuMetodo()).thenReturn("Retorno Mockado");

// Verificar interações
verify(minhaClasseMock, times(1)).meuMetodo();
```
Essa abordagem é muito mais prática e poderosa do que utilizar stubs tradicionais, além de ser mais adequada para projetos grandes e dinâmicos.

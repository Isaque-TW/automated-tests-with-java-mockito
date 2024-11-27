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
## Por que usar o Mockito em vez de Stubs?

Você pode estar se perguntando: "Mas ainda não usamos o Mockito, por que ele é tão importante?".  
Essa importância fica clara ao compará-lo com a abordagem de **stubs**, que apresenta várias desvantagens.

Imagine que, ao adicionar um novo método em uma interface, todos os stubs implementados anteriormente quebram. Isso ocorre porque cada stub precisa ser atualizado manualmente para incluir o novo método, mesmo que ele não seja utilizado.

Por exemplo, suponha que alteramos uma interface em um projeto:

```java
public interface CursoService {
    void fazerAlgo();
    void novaAssinatura(); // Novo método adicionado
}
```

Agora, todos os stubs que implementam essa interface precisam ser revisados e atualizados, o que não é prático, especialmente em projetos com dezenas ou centenas de desenvolvedores.

### Principais problemas com stubs:
1. **Alto custo de manutenção:** Cada mudança na interface exige revisão manual de todos os stubs.
2. **Complexidade com condições dinâmicas:** Implementar setups para stubs em cenários complexos consome muito tempo.
3. **Falta de escalabilidade:** Projetos grandes tornam essa abordagem insustentável.

### Como o Mockito resolve isso?
O Mockito elimina a necessidade de atualizar manualmente stubs ao permitir que dependências sejam simuladas automaticamente. Assim, mesmo que novos métodos sejam adicionados às interfaces, você não precisará implementar métodos desnecessários.

Além disso, o Mockito facilita a configuração de comportamentos dinâmicos e economiza tempo durante a escrita de testes, tornando o processo mais eficiente e produtivo.

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
# 🛒 Sistema de Gestão de Pedidos (com Observer + Reflexão)

Este projeto é uma implementação avançada do padrão de projeto comportamental **Observer**, evoluído com o uso de **Anotações** e **Reflexão** para atingir o desacoplamento total. Desenvolvido como trabalho final para a disciplina de **Programação Orientada a Objetos Avançada**.

*   **Curso:** Bacharelado em Engenharia de Software
*   **Disciplina:** Programação Orientada a Objetos Avançada
*   **Professor:** Mario Jorge
*   **Semestre:** 4º Semestre (2026.2)
*   **Equipe:**
    *   Emanuel Ferreira
    *   Filipe Pinho
    *   Kauã Araújo 
    *   Marcio Ventura
    *   Rodrigo dos Santos

## Arquitetura do Código

O sistema utiliza o padrão Observer para notificar múltiplos sistemas periféricos sobre a finalização de um pedido. A grande inovação desta versão é a **Inversão de Controle** via Reflexão: os observadores são descobertos e registrados automaticamente pelo sistema, sem necessidade de configuração manual na classe `Main`.

### Diagrama de Classes (Mermaid)

```mermaid
classDiagram
    class PedidoObserver {
        <<interface>>
        +pedidoFinalizado(Pedido pedido)
    }
    class ObserverAction {
        <<annotation>>
    }
    class RegistroAutomatico {
        +registrarObservadores(ServicoDePedidos servico)
    }
    class ServicoDePedidos {
        -List~PedidoObserver~ observers
        +registrar(PedidoObserver observer)
        +finalizarPedido(Pedido pedido)
    }
    
    class EmailObserver { +pedidoFinalizado(Pedido pedido) }
    class EstoqueObserver { +pedidoFinalizado(Pedido pedido) }

    EmailObserver ..|> PedidoObserver
    EstoqueObserver ..|> PedidoObserver
    EmailObserver ..> ObserverAction : @ObserverAction
    EstoqueObserver ..> ObserverAction : @ObserverAction
    
    RegistroAutomatico ..> ObserverAction : busca por
    RegistroAutomatico ..> ServicoDePedidos : registra em
    ServicoDePedidos o-- PedidoObserver : mantém
```

### Componentes Principais

1.  **Sujeito (`ServicoDePedidos`)**: Gerencia e notifica os observadores. Possui tratamento de erros (try-catch) no loop para garantir que a falha de um observador não interrompa os demais.
2.  **Anotação `@ObserverAction`**: Marca as classes que devem ser "plugadas" automaticamente no sistema.
3.  **Mecanismo de Reflexão (`RegistroAutomatico`)**: Escaneia o pacote de observadores em tempo de execução, instanciando e registrando dinamicamente todas as classes anotadas.
4.  **Observadores Concretos**: Classes como `EmailObserver`, `EstoqueObserver`, etc., que agora são totalmente independentes e auto-registráveis.

## Como Rodar Localmente?

### 1. Clonando o Repositório
```bash
git clone https://github.com/seu-usuario/projeto-observer-poo-avancada.git
cd projeto-observer-poo-avancada
```

### 2. Execução por Sistema Operacional

#### 🐧 Linux e 🍎 macOS
```bash
mkdir -p bin
javac -d bin -sourcepath src src/br/com/loja/Main.java
java -cp bin br.com.loja.Main
```

#### 🪟 Windows
```cmd
if not exist bin mkdir bin
javac -d bin -sourcepath src src/br/com/loja/Main.java
java -cp bin br.com.loja.Main
```

## 🧠 Conceitos Avançados Aplicados

*   **DIP (Dependency Inversion Principle)**: O sistema depende de abstrações, não de implementações.
*   **Inversão de Controle (IoC)**: O registro dos observadores não é mais controlado pela lógica principal (`Main`), mas sim pelo mecanismo de Reflexão.
*   **Java Reflection API**: Utilizada para introspecção de pacotes e instanciação dinâmica de objetos.
*   **Anotações Customizadas**: Criação de metadados próprios para guiar o comportamento da arquitetura.
*   **Resiliência (Isolamento de Falhas)**: Tratamento de exceções robusto no loop de notificação do padrão Observer.

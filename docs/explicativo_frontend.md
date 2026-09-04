# anotações descritivas/ explicativas

aqui vao as teorias rapidas pra consultar, a fim de tirar duvidas ou lembrar de algo;

- Primeira coisa vai ser construir a estrutura basica de pastas do projeto;
- No react usamos a extensão .jsx pra escrever nossos componentes, no retorno de cada função podemos escrever um scprit html que permite que o javaScript renderize html no navegador;
- O react é constituido de components que podem ser reutilizaos em suas paginas;
  
### estrutura de pastas React

A logica portras do react começa com o único arquivo html ele renderiza o main.jsx que por sua vez chama o App.jsx que chama os outros componentes.
A main acha o componente ``<root>`` dentro do html e renderiza o App.jsx;

---

![imagem de estruturas de pasta](../frontend/img/estrutura_pastas_react.png)


### sintaxe e funções exclusivas

- **inserção de outros componentes**:

````javaScript

function app(){
    return (
        <component1 />
    )
}
````

- **Props**: usado pra reutilizar componentes pra passar pra um componente usamos:
  
É como se as Prps fossem argumentos de uma função so que no caso sao passadas pra dentro do componente

````javaScript
<Header nome= "nome"/>// assim eu passo a variavel nome pra dentro do header

function Header(props) // assim eu recupero e uso ele dentro da meu componente
return (
    <h1> ola, {props.nome}<h1/>
)
````

- **useState**: quando o estado de algo muda, o react renderiza automaticamente, pra isso usamos o useState pra tudo que é dinamico no nosso codigo. Pra usa-lo precisamos importar do react;
  
````javaScript
import {useState} from 'react'

function App(){
    const [contador, setContador]= useState(0)// inicia a variavel contador com o valor '0'

    return (
        <div>
            <h1>Contador:{contador}<h1/>
            <button onClick={()=> setContador(contador+1)}><button/>// toda vez que eu clicar ele vai setar o contador com o antigo valor +1
        
        <div/>
    )
}
````

Um estado nao precisa ser um numero, ele pode ser String, Boole, Array e ate mesmo objeto 

- **Eventos**:
No tópico anterior usamos o `onClick`, que significa que quando um usuario clicar ali algo acontecera;
É importanto dentro desse escopo nao chamar a função, senao era sera executada quando carregar a pagina, sendo que queremos que aconteça apenas quando clicado, portanto deixamos sem o parenteses a chamada da função

````javaScript
onClick={algumaFuncao}
````

Para passar paremtros pra funções usamos a seguinte estrutura:

````javaScript
onClick={()=>algumaFuncao("parametro")}// desse modo continuamos a chamar a função apenas no click, usando a arrow function
````

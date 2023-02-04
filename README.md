# MUDI

O objetivo do projeto foi construir uma aplicação na qual fosse possível criar ofertas de compra e venda de produtos. Ao longo de dois treinamentos da Alura, foi criada então uma Web-aplicação utilizando as tecnologias abaixo. A única ressalva fica por conta da versão utilizada das tecnologias. Como os treinamentos foram de 2020, tomei a liberdade de utilizar as versões mais recentes das tecnologias. Devido a isso alguns pontos mais específicos necessitaram de uma implementação diferente da adotada pelo professor do curso.

- Java 17
- Spring Boot
- Spring Security
- Spring MVC
- Spring Data
- JPA
- Thymeleaf
- Bootrap
- Vue.js
- Banco de dados relacional (Oracle 21g)



## Funções

### Login
Foi implementada a autenticação básica através de usuário e senha, utiizando JDBC Authentication. Os dados de usuário ficam armazenados na base de dados com senha criptografada. Caso o usuário não esteja logado, só poderá visualizar a home. Até que a autenticação seja realizada, ele será redirecionado para o formulário de login se tentar acessar uma página que não seja a home.
![image](https://user-images.githubusercontent.com/76452862/216750449-fca8b415-b865-4e24-b5f6-1b1d0ea06f38.png)


### Home
A home da aplicação quando o usuário não está logado, exibe os últimos pedidos com staus entregue. Caso o usuário esteja logado, irá também exibir o menu de navegação para cadastro de pedidos e criação de ofertas.
![image](https://user-images.githubusercontent.com/76452862/216750472-2f13151c-fd42-423a-a5a0-72a87522dbfa.png)

### Meu pedidos
Esta área aparece para o usuário logado. Aqui ele pode navegador nos pedidos criados através do status do pedido. É possível também através do menu de navegação criar uma oferta ou criar um novo pedido.
![image](https://user-images.githubusercontent.com/76452862/216750608-a008c488-b5bb-4ba5-a749-5f842c52a5d3.png)

## Novo pedido
Clicando no botão "Novo" presente no menu de pedidos do usuário, o usuário é redicionado para a página de formulário de cadastro de novo pedido. Nesta página ele fornece alguns dados para cadastro de novo pedido, que pode ser submetido ofertas mais a diante. Neste formulário há validações de campos obrigatórios.
![image](https://user-images.githubusercontent.com/76452862/216750686-dc1e2de6-c6aa-4bbc-af5c-51bfa7a17e6b.png)

## Cadastrar oferta
Através do menu de navegação, é possível acessar a página de cadastro de novas ofertas. Esta área é reservada ao envio de ofertas a pedidos já cadastrados no sistema. (Esta tela foi feita utilizando Vue.js).
![image](https://user-images.githubusercontent.com/76452862/216750742-fe1f745b-3294-485d-8def-19ae704cfe3a.png)

## APIs
Foram criados 3 serviços REST com o entuito de "quebrar" a aplicação em camada back-end e camada front-end com a possibilidade de utilizar tecnologias desacopladas e também entender o comportamento de um serviço REST. Os serviços criados foram:
| Método | End-point | Descrição |
|--- |--- |--- |
| GET | /api/pedidos | Retorna todos os pedidos com status aguardando com um limite de 10 pedidos por página |
| POST | /api/ofertas | Cria uma oferta na base de dados com os dados vindos da tela de cadastro de ofertas |
| GET | /acessos | Acesso às informações gravados pelo interceptador |

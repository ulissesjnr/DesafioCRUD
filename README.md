# DesafioCRUD


Funcionalidades:


Bloco 1 - autenticação:

<ok> 1 - usuário "admin" com senha 123qwe!@#
<ok> usuário admin tem todas as permissões
<ok> 2 - usuário "user" com senha 123qwe123
<ok> usuário user tem apenas permissão de leitor (metodos GET)


Bloco 2 - serviços:

<ok> utilizar java 8
<ok> utilizar springboot
<ok> utilizar hibernate
<ok> utilizar Maven

Bloco 3 - Registro dos clientes

Nome
<ok> mínimo 3 caracteres;
<ok> máximo 100 caracteres;
<ok> Campo obrigatório;
<ok> Permite apenas letras, espaços e números


CPF
<> sempre deve ser mostrado com máscara;
<ok> deve ser persistido na base sem máscara;
<ok> é um campo obrigatório.

Endereço:
<ok> Obrigatório preencher CEP, logradouro, bairro, cidade e UF;
complemento opcional
<ok> outros dados não devem ser preenchidos
deve estar integrado com serviço de consulta de cep
<ok> usuario pode alterar os dados que vieram do serviço de consulta
cep deve ser mostrado com máscara
<ok> cep deve ser persistido sem máscara

Telefones:
<ok> permite multiplos telefones
<ok> pelo menos um telefone deve ser cadastrado
<ok> telefone deve ser persistido sem mascara
tipo de telefone

e-mail
<ok> permite multiplos emails
<ok> pelo menos um deve ser cadastrado
<ok> deve ser e-mail válido




Bloco 4 - Serviços adicionados:

<ok> - Criar um novo contato: 
http://localhost:8090/user com o método POST

JSON exemplo:
{
    "name": "Nome do Usuario",
    "cpf": "12345678811",
    "enderecoCEP": "12345678",
    "enderecoLogradouro": "Rua Exemplo, 123",
    "enderecoBairro": "vitoria",
    "enderecoCidade": "Cidade Exemplo",
    "enderecoUF": "UF",
    "telefones": ["12345678901", "98765432109"],
    "emails": ["email1@example.com", "email2@example.com"]
}

melhorias feitas: Adicionadas validações extras.

<ok> - Editar um contato:
http://localhost:8090/user/ com o método PUT

JSON exemplo:
{
    "id": "1",
    "name": "Nome do Usuario Mudou",
    "cpf": "12345678811",
    "enderecoCEP": "12345678",
    "enderecoLogradouro": "Rua Exemplo, 123",
    "enderecoBairro": "vitoria",
    "enderecoCidade": "Cidade Exemplo",
    "enderecoUF": "UF",
    "telefones": ["12345678901", "98765432109"],
    "emails": ["email1@example.com", "email2@example.com"]
}

<ok> - excluir um contato
http://localhost:8090/user/?id={"id do contato a ser deletado"} com o método DELETE

<ok> - exibir todos contatos
http://localhost:8090/user/all com o método GET

<ok> - exibir um contato pelo id
http://localhost:8090/user/?id={"id do contato a ser exibido"} com o método GET
# DesafioCRUD

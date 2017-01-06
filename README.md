# ProvaJava
Configuração Inicial:
- Realize o Fork deste repositório git; 
- Leia cuidadosamente este documento e implemente os requisitos aqui descritos; 
- Responda o e-mail que você recebeu do RH inluindo um link para seu repositório git até a data limite informada; 
 
Requisitos a serem  implementados pelo candidato:
- Melhore a experiência do usuário usando seu melhor julgamento. Nos impressione mudando a fonte, incluindo imagens/glyphicons e mudando as cores utilizadas no tema; 
- Atenda os requisitos descritos na especificação da aplicação: 
 
Especificação da aplicação:
A gerência de uma biblioteca deve se preocupar com a qualidade dos seus produtos e dos serviços oferecidos a seus clientes. Esta é a meta principal de sua atuação e para alcançar o aumento de qualidade e produtividade deve-se identificar e eliminar todos os obstáculos. 
 
A Direção da Fundação Biblioteca, em sua nova fase, tem como um de seus objetivos a busca da qualidade total de seus serviços e produtos, o que permite maximizar o potencial institucional, reduzir custos e oferecer atendimento de excelência.  Para tal, foi contratado especialista na busca da Eficácia e Qualidade Organizacional, que vêm desenvolvendo junto a cada gerente, um trabalho voltado para cada um dos setores, obedecendo a métodos bem sucedidos de administração.
 
Como resultado deste trabalho foram solicitadas diversas melhorias para o sistema de controle das bibliotecas da Fundação, de forma a permitir o melhor retorno sobre esse trabalho e a melhor usabilidade para seus utilizadores. 
 
Na primeira fase da transformação alguns bugs conhecidos precisam ser corrigidos: atualmente ao logar e deslogar existe repetição de livros e autores. Isso não deve mais acontecer. 
 
Para melhorar a usabilidade será necessário criar um novo template preto e laranja utilizando o primeface e o menu vertical deverá ser transformado da vertical para a horizontal. 
 
Para facilitar o controle de empréstimos, deverá ser criada uma tela para cadastrar usuários, onde apenas o perfil Administrador pode realizar alterações e exclusão. Além disso, na tela de controle de autores, várias modificações na lista de autores serão necessárias para permitir que seja exibida a quantidade de livros por autores com o texto "Qtd. Livro:". Também será necessário implementar a funcionalidade alterar autores e manter na tela de autores após as ações executadas.
 
Ainda na tela de lista de autores será necessário implementar a funcionalidade excluir autores, com a exibição de mensagem de confirmação e de forma a impedir a repetição de registros.
 
Na tela de criação de livros a sessão inclusão de autor deve ser exibida em duas situações ao iniciar a digitação/criação de um livro ou quando clicado no botão alterar. Além disso, deverá ser inibida a inclusão de autores repetidos
 
Na tela da função de listar os livros será necessário centralizar os botões da grid alterar e remover. Também deverá ser excluído o componente de paginação superior, mantendo apenas o inferior. Além disso, para aumentar a segurança do sistema deverá ser implementada na funcionalidade de exclusão de livros um modal de confirmação para a ação. Ainda nesta tela, centralizar o botão Gravar e retirar o fundo preto desta sessão para melhorar a usabilidade para os usuários. 
 
Por fim, para facilitar o login dos usuários, na tela login será necessário manter os e-mails validos digitados em cookies.





// MINHAS OBSERVAÇ˜OES:
 - TABELA USUARIO TEM QUE TER UMA COLUNA BOOLEAN PARA DESABILITAR O USU´ARIO E NAO DELET´A-LO, ASSIM TAMBEM COM AS TABELAS LIVRO E AUTOR POIS ESSES DADOS PODERAO SER USADOS POSTERIOR PARA RELAT´ORIOS/BALANCO/AUDITORIA/ETC
 

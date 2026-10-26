# language: pt
# Feature de autenticação com cenários positivos e negativos
Funcionalidade: Autenticação de usuário

  # Cenário de sucesso
Cenário: Login válido
Dado que o usuário "admin" com senha "1234" está cadastrado
Quando eu faço login com "admin" e "1234"
Então o acesso é concedido

  # Cenário de falha
Cenário: Senha inválida
Dado que o usuário "admin" com senha "1234" está cadastrado
Quando eu faço login com "admin" e "senhaerrada"
Então o acesso é negado
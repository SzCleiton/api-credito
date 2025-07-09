🚀 API de Consulta de Créditos - Desafio Técnico
Bem-vindo ao repositório da solução do desafio técnico para a API de Consulta de Créditos. Este projeto foi desenvolvido utilizando uma arquitetura de monorepo robusta, escalável e com uma clara separação de responsabilidades.

🏛️ Arquitetura da Solução
A aplicação é orquestrada pelo Docker Compose e dividida em três domínios principais, seguindo as melhores práticas de desenvolvimento de software:

📁 backend
Contém todos os microserviços da aplicação. O serviço principal é:

services/credito-api: Uma API RESTful construída com Spring Boot e Arquitetura Hexagonal. Ela é o cérebro da aplicação, responsável por toda a lógica de negócio e comunicação com o banco de dados e o sistema de mensageria.

📁 frontend
Contém as aplicações de interface do usuário.

apps/credito-ui: Uma Single Page Application (SPA) moderna, desenvolvida em Angular com uma arquitetura modular. A interface é servida por um container Nginx otimizado para produção.

📁 infrastructure
Centraliza toda a configuração de ambiente, orquestração e scripts de banco de dados.

docker-compose.yml: O coração da infraestrutura, responsável por orquestrar a subida de todos os serviços: PostgreSQL, Kafka, a API e a UI.

db/init: Contém os scripts SQL (.sql) para a criação do schema e a população inicial do banco de dados, garantindo um ambiente consistente a cada inicialização.

🛠️ Como Executar o Projeto
Siga os passos abaixo para ter a aplicação completa rodando em sua máquina local.

1. Pré-requisitos
   Antes de começar, garanta que você tenha as seguintes ferramentas instaladas:

Docker

Docker Compose (geralmente já incluído no Docker Desktop)

2. Inicie a Aplicação
   Todo o processo é automatizado pelo Docker Compose.

Clone este repositório para a sua máquina.

Abra um terminal e navegue até a pasta infrastructure:

cd infrastructure/

Execute o seguinte comando para construir as imagens e iniciar todos os containers em modo "detached" (em segundo plano):

docker-compose up --build -d

A flag --build força a reconstrução das imagens, garantindo que quaisquer alterações no código sejam aplicadas.

A flag -d libera o seu terminal após a inicialização.

3. Acesse a Aplicação
   Após a conclusão do comando, os serviços estarão disponíveis nos seguintes endereços:

🖥️ Frontend: http://localhost:4200

⚙️ API Backend: http://localhost:8080/api/creditos

4. Parando a Aplicação
   Para parar e remover todos os containers relacionados ao projeto, execute o seguinte comando no mesmo diretório (infrastructure/):

docker-compose down

Dica: Se desejar apagar também os dados persistidos do banco de dados (o volume do Docker), use docker-compose down -v.
🏥 UniqueSUS – Automação do Atendimento no Pronto-Socorro (SUS)

UniqueSUS é uma solução pensada para transformar o atendimento de urgência e emergência no Sistema Único de Saúde (SUS), automatizando o processo desde a entrada do paciente até a geração de indicadores estratégicos para gestão hospitalar.

------------------------------------------------------------
🚀 Objetivo

Reduzir a sobrecarga nos prontos-socorros, melhorar a experiência do paciente e fornecer dados confiáveis para profissionais e gestores da saúde pública.

------------------------------------------------------------
🧩 Funcionalidades

- Entrada digital do paciente via API, aplicativo ou totens de autoatendimento
- Monitoramento em tempo real das etapas de atendimento: triagem, consulta, medicação e internação
- Consulta da posição na fila e tempo estimado de atendimento
- Geração de indicadores para análise e melhoria contínua
- Arquitetura flexível para integração com sistemas existentes do SUS

------------------------------------------------------------
🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- MySQL
- Docker & Docker Compose
- Clean Architecture

------------------------------------------------------------
⚙️ Processo de Desenvolvimento

O projeto teve início com a elaboração de uma lista abrangente de ideias voltadas à melhoria do sistema SUS. Em seguida, realizei uma análise de viabilidade, considerando critérios como tempo de desenvolvimento, complexidade técnica e impacto social. A proposta selecionada foi a automação do atendimento nos prontos-socorros, por se tratar de uma solução de alta relevância, com grande potencial de transformação e compatível com o prazo disponível para entrega do MVP.

------------------------------------------------------------
🧪 Detalhes Técnicos

O MVP foi desenvolvido em Java 21, seguindo os princípios da Clean Architecture, utilizando o framework Spring Boot e o banco de dados MySQL como repositório principal.
A aplicação foi estruturada como um monólito, porém sua arquitetura modular permite uma transição fluida para microserviços no futuro, sem grandes refatorações.
Todo o sistema é containerizado com Docker, composto por dois containers: um para a aplicação e outro para o banco de dados. Essa abordagem garante escalabilidade, portabilidade e flexibilidade para execução em ambientes cloud ou on-premises.

------------------------------------------------------------
📦 Estrutura de Containers

- uniquesus-app: aplicação backend Spring Boot
- uniquesus-mysql: banco de dados MySQL
- Ambos os serviços rodam em containers separados e compartilham uma rede interna (uniquesus-network)

------------------------------------------------------------
🧰 Como Executar

1. Gere o .jar da aplicação:
   ```bash
   mvn clean package

2. Suba os containers com Docker Compose:
   ```bash
   docker-compose up -d

3. Acesse a aplicação em:
http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------
📈 Próximos Passos

- Monitoramento da administração de medicação
- Rastreamento de processos de internação
- Expansão para outras áreas hospitalares
- Geração de relatórios estratégicos para gestão pública

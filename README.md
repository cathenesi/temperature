# Demo de conexão via web-socket

Esse serviço recebe medição de temperatura e humidade pelo endpoint "/listener" e o publica em tópico websocket.

Cada amostra também é grava em banco de dados.

##### Font-end

http://localhost:9052

##### Documentação da API 

http://localhost:9052/swagger-ui.html

## Módulo de leitura de temperatura e humidade

A temperatura e humidade é registrada por meio de um programa Python que roda eum um Raspberry Pi.

O programa se encontra no diretório "python".

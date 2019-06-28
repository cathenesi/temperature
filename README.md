# Demo de aplicação com conexão via web-socket

Esse serviço recebe medição de temperatura e humidade pelo endpoint "/listener" e o publica em tópico websocket. 

O front-end é atualizado automaticamente a cada medição.

Cada amostra medida também é gravada no Redis; quando um usuário abre o front-end, a última medição é obtida.


##### Font-end

http://localhost:9052


##### Documentação da API 

http://localhost:9052/swagger-ui.html


## Módulo de leitura de temperatura e humidade

A temperatura e humidade é registrada por meio de um programa Python que roda em um Raspberry Pi. 
O programa lê os dados por meio de um sensor DHT11:
![](DHT11-com-Raspberry.png)

O programa se encontra no diretório "python", e foi adaptado a partir da referência:
https://www.filipeflop.com/blog/temperatura-umidade-dht11-com-raspberry-pi/


## Front-end rodando na AWS
http://52.87.157.137:9052/


## Documentação da API rodando na AWS
http://52.87.157.137:9052/swagger-ui.html

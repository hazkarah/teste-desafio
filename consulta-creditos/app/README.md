# App

Este projeto foi gerado com [Angular CLI](https://github.com/angular/angular-cli) versão 20.1.3.

## Tecnologias Utilizadas

- **Angular**: 20.1.3
- **Node.js**: 20.x
- **npm**: 10.x
- **Angular Material**: Utilizado para componentes visuais

## Servidor de Desenvolvimento

Execute `ng serve` para iniciar o servidor de desenvolvimento. Acesse `http://localhost:4200/`. A aplicação será recarregada automaticamente ao alterar os arquivos fonte.

### Proxy para API

Para redirecionar chamadas para `/api` durante o desenvolvimento, utilize o arquivo `proxy.conf.json` já configurado no projeto. Execute o comando abaixo:

```
ng serve --proxy-config proxy.conf.json
```

Assim, todas as requisições para `/api` serão encaminhadas para o backend conforme definido no arquivo de configuração.

## Geração de Código

Execute `ng generate component nome-do-componente` para gerar um novo componente. Também é possível usar `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Execute `ng build` para compilar o projeto. Os artefatos serão armazenados na pasta `dist/`.

## Testes Unitários

Execute `ng test` para rodar os testes unitários via [Karma](https://karma-runner.github.io).

## Testes End-to-End

Execute `ng e2e` para rodar os testes end-to-end. Para usar este comando, é necessário adicionar um pacote que implemente esta funcionalidade.

## Ajuda

Para mais informações sobre Angular CLI utilize `ng help` ou acesse a [documentação oficial](https://angular.dev/tools/cli).

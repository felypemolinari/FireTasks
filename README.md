# Fire Tasks

Aplicativo Android nativo de Lista de Tarefas (To-Do List) com sincronização em tempo real na nuvem.

## Sobre o Projeto
Desenvolvido como atividade avaliativa para a disciplina de **Programação para Dispositivos Móveis** da **UNIVALI**.

* **Aluno:** Felype Cesar Molinari

## Tecnologias Utilizadas
* **Linguagem:** Kotlin
* **Interface:** Jetpack Compose
* **Backend:** Firebase Cloud Firestore
* **Arquitetura:** MVVM (Model-View-ViewModel)

## Funcionalidades
O aplicativo implementa o ciclo completo de CRUD:
* **Criar:** Adicionar novas tarefas.
* **Ler:** Listagem atualizada em tempo real (Real-time updates).
* **Atualizar:** Marcar tarefas como concluídas/pendentes.
* **Excluir:** Remover tarefas do banco de dados.

## Configuração para Rodar
Para executar este projeto, é necessário configurar o Firebase:

1.  Crie um projeto no [Console do Firebase](https://console.firebase.google.com/).
2.  Baixe o arquivo `google-services.json` e coloque-o na pasta `app/` do projeto.
3.  Habilite o **Cloud Firestore** no console.
4.  Configure as regras de segurança para modo de teste (`allow read, write: if true;`).

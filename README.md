# 📘 POC de Autenticação via API Key em Aplicação Spring Boot

Este projeto demonstra uma **Proof of Concept (POC)** para implementação de autenticação baseada em **API Key** em uma aplicação web utilizando **Spring Boot** e **Servlet Filters**.

---

## 🔑 Objetivo
Garantir que apenas requisições autenticadas com uma **API Key válida** possam acessar endpoints protegidos (`/api/*`), enquanto endpoints públicos permanecem acessíveis sem autenticação.

---

## ⚙️ Estrutura da Implementação

### 1. **Filtro de Autenticação (`ApiKeyFilter`)**
- Intercepta todas as requisições para `/api/*`.
- Valida o header `Authorization` no formato:
  ```
  Authorization: Bearer <API_KEY>
  ```
- Caso inválido ou ausente → retorna **401 Unauthorized**.

### 2. **Configuração (`SecurityConfig`)**
- Registra o filtro para atuar apenas em endpoints `/api/*`.

### 3. **Configuração da API Key (`application.yml`)**
```yaml
security:
  api-key: API_60bKrLrQOoB1sNCOPGPLZtxFyIVSoupUhA5p7rU3kkyyyAywS7361QuT4FRJTsMK
```

### 4. **Controllers**
- **`InfoController`** → endpoint público (`/info`).
- **`HelloController`** → endpoint protegido (`/api/hello`).

---

## 🚀 Endpoints

### 🔓 Público
- **GET `/info`**
    - Não requer API Key.
    - Retorna informações básicas do projeto.

#### Exemplo de requisição:
```bash
curl -i http://localhost:8080/info
```

---

### 🔒 Protegido
- **GET `/api/hello`**
    - Requer API Key válida no header `Authorization`.
    - Retorna mensagem confirmando acesso autenticado.

#### Exemplo de requisição:
```bash
curl -i -H "Authorization: Bearer API_60bKrLrQOoB1sNCOPGPLZtxFyIVSoupUhA5p7rU3kkyyyAywS7361QuT4FRJTsMK" \
     http://localhost:8080/api/hello
```

---

## 📂 Fluxo de Autenticação

1. Cliente envia requisição para `/api/*` com header `Authorization`.
2. `ApiKeyFilter` valida se o valor corresponde à chave configurada.
3. Se válido → requisição segue para o controller.
4. Se inválido → resposta `401 Unauthorized`.

---

## ✅ Considerações Técnicas
- Implementação simples e extensível.
- Ideal para **POCs, serviços internos ou integrações rápidas**.
- Não substitui mecanismos robustos como **OAuth2, JWT ou OpenID Connect** em cenários de produção.
- Pode ser facilmente adaptado para múltiplas chaves ou armazenamento em banco de dados.

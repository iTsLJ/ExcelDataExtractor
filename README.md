# 📊 Excel Data Extractor

Excel Data Extractor é uma aplicação Java baseada em Spring Boot para extração e processamento de dados de arquivos Excel (`.xlsx`). Utiliza a biblioteca Apache POI para manipulação de planilhas e expõe uma API REST para receber e processar os arquivos.

## 🚀 Funcionalidades
- 📂 Upload de arquivos Excel
- 🔄 Extração automática dos dados e conversão para objetos Java
- 🖥️ API REST para consumo dos dados extraídos
- 📝 Log integrado para monitoramento de erros
- 📑 Documentação automática com Swagger UI

## 🛠 Tecnologias Utilizadas
- **Java 21+**
- **Spring Boot**
- **Apache POI**
- **Lombok**
- **Gradle**
- **Swagger UI**

## 📦 Como Executar o Projeto

1. **Clone este repositório:**
   ```bash
   git clone https://github.com/iTsLJ/ExcelDataExtractor.git
   ```
2. **Acesse o diretório do projeto:**
   ```bash
   cd ExcelDataExtractor
   ```
3. **Compile e execute a aplicação:**
   ```bash
   ./gradlew bootRun
   ```

## 📡 Endpoints da API

### 📤 Upload de Arquivo Excel
```http
POST /ExcelDataExtractor
```
**Parâmetro:** `file` (MultipartFile)

### 📋 Exemplo de Resposta
```json
[
  {
    "nome": "Lucas",
    "idade": 25
  },
  {
    "nome": "Mariana",
    "idade": 32
  }
]
```

## 📖 Documentação da API
A documentação da API está disponível via Swagger UI. Após iniciar a aplicação, acesse:
```
http://localhost:8080/swagger-ui.html
```

## 📜 Licença
Este projeto está sob a licença MIT. Sinta-se à vontade para utilizá-lo e modificá-lo conforme necessário.

---
**Desenvolvido por Lucas Ferreira** 🚀


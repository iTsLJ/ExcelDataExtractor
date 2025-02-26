# 📊 ExcelDataExtractor

ExcelDataExtractor é um serviço desenvolvido em Java com Spring Boot para extrair e processar dados de arquivos Excel. Ele utiliza a biblioteca Apache POI para manipulação de arquivos `.xlsx`, convertendo os dados em objetos Java acessíveis via API REST.

## 🚀 Funcionalidades
- 📂 Upload de arquivos Excel
- 🔄 Conversão automática dos dados em objetos Java
- 🖥️ API REST para consulta dos dados extraídos
- 📝 Log integrado para monitoramento de erros

## 🛠 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Apache POI**
- **Lombok**

## 📦 Instalação e Uso
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/ExcelDataExtractor.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd ExcelDataExtractor
   ```
3. Instale as dependências e compile o projeto:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

## 📡 Endpoints da API
### 📤 Upload de arquivo Excel
```http
POST /excel
```
**Parâmetro:** MultipartFile `file`

### 📋 Retorno esperado
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
---
**Desenvolvido por Lucas Ferreira** 🚀


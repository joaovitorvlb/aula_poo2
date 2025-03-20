# Diretórios
SRC_DIR := src
BIN_DIR := bin

# Pacotes
PACKAGES := principal model

# Arquivos .java
SOURCES := $(foreach pkg, $(PACKAGES), $(wildcard $(SRC_DIR)/$(pkg)/*.java))

# Arquivos .class correspondentes
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Classe principal
MAIN_CLASS := principal.AplicacaoPrincipal

# Nome do arquivo JAR
JAR_NAME := aplicacao.jar

# Compilador
JAVAC := javac

# Executor
JAVA := java

# Ferramenta para criar JAR
JAR := jar

# Opções de compilação
JAVAC_FLAGS := -d $(BIN_DIR) -sourcepath $(SRC_DIR)

# Alvo padrão
default: run

# Regra para compilar todos os arquivos .java
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)
	$(JAVAC) $(JAVAC_FLAGS) $<

# Alvo para compilar o projeto
compile: $(CLASSES)

# Alvo para criar o arquivo JAR
package: compile
	@echo "Manifest-Version: 1.0" > $(BIN_DIR)/manifest.txt
	@echo "Main-Class: $(MAIN_CLASS)" >> $(BIN_DIR)/manifest.txt
	@cd $(BIN_DIR) && $(JAR) cfm $(JAR_NAME) manifest.txt $(foreach pkg, $(PACKAGES), $(pkg)/*.class)
	@rm $(BIN_DIR)/manifest.txt
	@echo "Arquivo $(JAR_NAME) criado com sucesso no diretório $(BIN_DIR)."

# Alvo para executar o projeto a partir do JAR
run: package
	$(JAVA) -jar $(BIN_DIR)/$(JAR_NAME)

# Alvo para limpar os arquivos compilados
clean:
	rm -rf $(BIN_DIR)/*

.PHONY: default compile package run clean

Boas praticas com prompts e personas

Persona: É como um personagem que vai interpretar. Ex: "Voce agora é um especialista em IA,"
Prompt: É o roteiro que a persona vai seguir.
Sistema: É como a persona deve se comportar. 

**DICAS PRATICAS**
Ser especifico, para a IA funcionar melhor,
dar exemplos no prompt, se quiser que algo fique parecido
Os campos "tonalidade", "objetivo", "contexto" e "limite de palavras" ajudam a moldar essa persona entao use eles
Usar com moderacao ** para **negrito** | - para **lista** | ## para **titulos**



Diferencas entre o Modelfile.txt e o endpoint /api/chat

é como se fosse o chat ao vivo com a IA.
voce envia a mensagem e ele responde.

Modelfile -> é um manual da IA
pode definir caracteristicas fixas da IA 

Para usar os 2 juntos configurar o comportamento geral no Modelfile.txt.
E usar o /api/chat para enviar instrucoes em tempo real.


Parameters | Temperature (0 - 1) Quanto mais perto de 0 Respostas previsiveis (seguira a risca) quanto mais perto de 1 vai ser menos preciso mas mais criativo e mais extenso na resposta provavelmente
| Max Tokens: Limite de palavras na resposta |
Top p(0 - 1) controla a variedade de ideias 

#### SEMPRE estruture perguntas assim:
1. Resumo curto
2. 3 pontos-chave
3. Exemplo prático

##### Nao usar ambiguidade
- ❌ Ruim: "Não seja muito técnico."
- ✅ Bom: "Use linguagem simples, equivalente ao ensino médio."

#### Adicionar gatilhos
- Se o usuário parecer confuso, ofereça ajuda adicional com um exemplo. 


## vraptor-erb

Uma biblioteca simples, compatível com o erb nas views.

# instalação

É possível fazer o download do vraptor-erb.jar do repositório do Maven, ou configurado em qualquer ferramenta compatível:

		<dependency>
			<groupId>br.com.caelum.vraptor</groupId>
			<artifactId>vraptor-erb</artifactId>
			<version>1.0.0</version>
			<scope>compile</scope>
		</dependency>


# Renderizando um template

		new Erb().render(templateName, localVariablesMap);
	
# Gems
		
Caso queira usar gems dentro de seu template (!?) você deve colocá-las em um diretório chamado "gems". (to improve)

# VRaptor View

(em breve) Basta colocar o jar no seu projeto e configurar a view para ser sua default

# Ajuda

Envie perguntas no forum de perguntas e respostas do http://www.guj.com.br
## vraptor-erb

Uma biblioteca simples, compatível com o erb nas views.

# instalação

É possível fazer o download do vraptor-erb.jar do repositório do Maven, ou configurado em qualquer ferramenta compatível:

		<dependency>
			<groupId>br.com.caelum.vraptor</groupId>
			<artifactId>vraptor-erb</artifactId>
			<version>0.9.0</version>
			<scope>compile</scope>
		</dependency>

# VRaptor View

Basta colocar o jar no seu projeto e usar em sua view:

	result.use(erb()); // com static import de ErbView.class

Note que o diretório de suas views é "/WEB-INF/jsp/controller/method.erb". O nome "jsp" parece não fazer sentido
mas ele representa o local onde encontramos as views.

Ou ainda:

	result.use(ErbView.erb()); // OU;
	result.use(ErbView.class);

# VRaptor View como padrão

Basta criar um componente que herda de ErbPathResolver e está anotado com @Component.

	@Component
	public class MyErbResolver extends ErbPathResolver {
	}
	
Não carregamos esse componente de view por padrão pois imaginamos que os usuários do vraptor-erb começarão migrando suas views para erb.

# Migrando um projeto com jsp

Se você deseja migrar um projeto que usava jsp recomendamos que comece usando o result.use(erb()) até que todas suas views sejam erbs.
Nesse instante remova todas essas linhas e siga o passo do padrão ao utilizar seu MyErbResolver.

# Renderizando fora do VRaptor

		new Erb().render(templateName, localVariablesMap);
	
# Gems

Caso queira usar gems dentro de seu template (!?) você deve colocá-las em um diretório chamado "gems". (to improve)


# Ajuda

Envie perguntas no forum de perguntas e respostas do http://www.guj.com.br
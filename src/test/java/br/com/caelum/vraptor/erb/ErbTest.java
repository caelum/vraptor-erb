package br.com.caelum.vraptor.erb;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;

import org.junit.Test;

import br.com.caelum.vraptor.erb.Erb;

public class ErbTest {

	@Test
	public void should_translate_a_resource() throws ScriptException {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "guilherme");
		assertEquals("guilherme", new Erb().render("simpleVariable.html.erb", map));
	}

	@Test
	public void should_support_objects() throws ScriptException {
		Map<String, Object> map = new HashMap<>();
		map.put("user", new User("joviane", "jardim"));
		assertEquals("joviane jardim", new Erb().render("user.html.erb", map));
	}

	@Test
	public void should_support_each() throws ScriptException {
		Map<String, Object> map = new HashMap<>();
		map.put("users", Arrays.asList(new User("joviane", "jardim"),new User("guilherme", "silveira")));
		assertEquals("joviane jardim e guilherme silveira", new Erb().render("users.html.erb", map));
	}

}

package br.com.caelum.vraptor.erb;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;
import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.resource.ResourceMethod;

public class ErbView implements View {
	
	public ErbView(Result result, FormatResolver resolver, ResourceMethod method) {
		String to = new ErbPathResolver(resolver).pathFor(method);
		result.forwardTo(to);
	}
	
	public static Class<ErbView> erb() {
		return ErbView.class;
	}

}

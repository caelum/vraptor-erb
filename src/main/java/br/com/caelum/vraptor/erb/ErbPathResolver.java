package br.com.caelum.vraptor.erb;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

public class ErbPathResolver extends DefaultPathResolver{

	public ErbPathResolver(FormatResolver resolver) {
		super(resolver);
	}
	
	@Override
	protected String getExtension() {
		return "erb";
	}
	
}

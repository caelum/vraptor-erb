package br.com.caelum.vraptor.erb;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.Component;

class Controle {
	private ClientsView cv;
	Controle(ClientsView cv) {
		this.cv = cv;
	}
	public void xpto() {
		cv.showName("variavel");
	}
}




@VRaptorView
public interface ClientsView {
	void showName(String name);
}








@ interface VRaptorView {
}
@Component
class ClientsViewImplementation implements ClientsView{

	private Result result;
	public ClientsViewImplementation(Result result) {
		this.result = result;
	}
	
	@Override
	public void showName(String name) {
		result.include(name, "name");
		result.forwardTo("/clients/showName.jsp");
	}
}
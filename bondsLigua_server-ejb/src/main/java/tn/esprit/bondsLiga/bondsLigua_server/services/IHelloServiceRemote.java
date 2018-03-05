package tn.esprit.bondsLiga.bondsLigua_server.services;

import javax.ejb.Remote;

@Remote
public interface IHelloServiceRemote {
	public String sayHello(String msg);
	

}

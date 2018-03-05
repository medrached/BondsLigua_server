package tn.esprit.bondsLiga.bondsLigua_server.services;


import javax.ejb.Stateless;

@Stateless
public class HelloService implements IHelloServiceRemote {

@Override
	public String sayHello(String msg) {
		return msg;
	}
}

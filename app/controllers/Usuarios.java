package controllers;

import java.net.UnknownHostException;

import models.Jugador;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.Mongo;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author rfanego
 */
public class Usuarios extends Controller {
	public static Result registrar() {
		JsonNode json = request().body().asJson();
		if(json == null){
			return badRequest();
		}else{
			String usuario = json.get("usuario").asText();
			String clave = json.get("clave").asText();
			String tipo = json.get("tipo").asText();

			String dbName = new String("tutti");
			Mongo mongo = null;
			try {
				mongo = new Mongo( "localhost", 27017 );
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Morphia morphia = new Morphia();
			Datastore datastore = morphia.createDatastore(mongo, dbName); 
			
			morphia.mapPackage("models");
			
			Jugador jugador = new Jugador();
			jugador.setNickname(usuario);
			jugador.setClave(clave);
			if(tipo.equals("mail")){
				jugador.setMail(usuario);
			}
			
			datastore.save(jugador);

			return ok();
		}
    }
	
	public static Result validar() {
		
        return ok();
    }
}

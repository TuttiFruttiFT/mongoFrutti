package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @author rfanego
 */
@Entity
public class Jugador {
	@Id 
	private ObjectId id;
	
	private String nickname;
	
	private String mail;
	
	private String facebook;
	
	private String twitter;
	
	private Integer saldoRus;
	
	private String clave;
}

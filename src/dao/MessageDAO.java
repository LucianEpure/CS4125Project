package dao;

import service.Message;

public class MessageDAO extends AbstractDAO<Message> {
	
	public MessageDAO(){
		this.uniqueIdentifierFieldName = "referenceNumber";
	}

}

package db.dao;

import frame.exception.ResourceException;

public class ConcreteDao extends Dao {
	public void select() throws ResourceException {
		connect();
		close();
	}
}

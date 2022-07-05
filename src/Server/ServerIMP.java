package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Controller.Dao;
import Model.benhnhan;

public class ServerIMP extends UnicastRemoteObject implements IServer {

	private Dao dao;

	public ServerIMP() throws RemoteException {
		super();
		this.dao = new Dao();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String add(benhnhan benhnhan) throws RemoteException {
		return dao.add(benhnhan);
	}

	@Override
	public String edit(benhnhan benhnhan) throws RemoteException {
		return dao.edit(benhnhan);
	}

	@Override
	public String del(String id) throws RemoteException {
		return dao.del(id);
	}

}

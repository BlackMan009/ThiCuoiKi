package Server;
import java.rmi.*;

import Model.benhnhan;

public interface IServer extends Remote{
	public String add(benhnhan benhnhan) throws RemoteException;
	
	public String edit(benhnhan benhnhan) throws RemoteException;
	
	public String del(String id) throws RemoteException;
}

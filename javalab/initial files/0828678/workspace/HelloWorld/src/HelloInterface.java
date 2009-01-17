import java.rmi.*;


public interface HelloInterface extends Remote {
/**
 * This is a sample method.
 * Delete it and add one of your own.
 * @return String message
 * @throws RemoteException
 */
	
	public String say () throws  RemoteException;
}

package iRMI;

import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Lucas Soumille
 * @version 19/05/16.
 */
public interface IRMIRegistry extends Remote {

    /**
     * Add a new entry <name , obj> in our Registry
     * @param name
     * @param obj
     */
    void bind(String name, Serializable obj) throws RemoteException, AlreadyBoundException;

    /**
     * Replace the entry for the specified name in our Registry
     * @param name
     * @param obj
     */
    void rebind(String name, Serializable obj) throws RemoteException;

    /**
     * Return the corresponding Object
     * @return
     */
    Serializable lookup(String name) throws RemoteException;

    /**
     * Update the name of the corresponding entry with the newName
     * @param name
     * @param newName
     */
    void rename(String name, String newName) throws RemoteException;

    /**
     * Remove the entry our Registry
     * @param name
     */
    void unbind(String name) throws RemoteException;

    /**
     * Return an array with all the entry names
     * @return
     */
    String[] list() throws RemoteException;

    /**
     * Return an array with the n last keys
     * @return
     */
    String[] getLastKeys(int n) throws RemoteException;

    /**
     * Return an array with the n last couple (key, object)
     * @return
     */
    String[] getLastEntries(int n) throws RemoteException;

    /**
     * Return true if the name in parameter is a service, false otherwise
     * @param name
     * @return
     * @throws RemoteException
     */
    public boolean isService(String name) throws RemoteException;
}

package com.city.services.data;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.city.model.obj.pune.Site;
/** 
 * Data layer.
 * @author santosh yevle
 */
public interface DataLayerPune {

    /**
     * Deletes the given object from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to delete
     */
    <T> void delete(T persistentObject);
    /**
     * Refresh the object $class.className from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to reload
     */
    <T> void refresh(T persistentObject);

    /**
     * Saves the given object to disk.
     * @param persistentObject Object to save
	 * @param <T> A DataLayerObject-derived type
     * @return Identifier of saved object 
     */
    <T> Serializable save(T persistentObject);
    /**
     * Saves or updates the given $class.className object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to save 
     */
    <T> void saveOrUpdate(T persistentObject);
    /**
     * Updates the given object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to update 
     */
    <T> void update(T persistentObject);


    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Site obj) directly
     * @param id Identifier to delete
     */
    void deleteSite(final Long id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Site object
     */
    Site loadSite(final Long id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Site getSite(final Long id);  
    /** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     Query createQuery(final String query);
    /** Returns a criteria handle.
     * @param criteria Criteria to use
     * @return A criteria instance
     */
     Criteria createCriteria(final String criteria);
    /** Returns a Query handle based on your package-level named query.
     * @param query Query to use
     * @return A query instance
     */
     Query getNamedQuery(final String query);
    /** Create a new Criteria instance, for the given entity class, or a superclass of an entity class.
	* @param persistentObject a class, which is persistent, or has persistent subclasses 
	* @return Criteria instance
	*/
	@SuppressWarnings("unchecked")
	Criteria createCriteria(Class persistentObject);
    /** Flushes the currently open session.
	*/
	void flushSession();
    /** Clears the currently open session.
	*/
	void clearSession();
    /** Flushes and clears the currently open session.
	*/
	void flushAndClearSession();
	/** Call currentSession.replicate.
	 * @param obj to replicate
	 * @param replicationMode mode
	 */ 
	void replicate(Object obj, ReplicationMode replicationMode);
	/** Hibernate Merge. 
	 * @param obj to merge
	 * @return obj merged.
	 */
	Object merge(Object obj);
	/** Returns the current session.
	 * @return the currently active session
	 */
	Session getCurrentSession();
	/** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     SQLQuery createSQLQuery(final String query);
    /** Remove this instance from the session cache. 
	 * Changes to the instance will not be synchronized with the database
	 * @param obj object to evict
	 */
	void evict(Object obj);
    /**
     * Return the persistent instance of the given entity class with the given 
     * identifier, or null if there is no such persistent instance. 
     * (If the instance, or a proxy for the instance, is already 
     * associated with the session, return that instance or proxy)
     *
     * @param clazz a persistent class
     * @param id a valid identifier of an existing persistent instance of the class
     * @return a persistent instance or null
     * @throws HibernateException
     */
	Object get(Class<?> clazz, Serializable id) throws HibernateException;	


    /**
     * Return the persistent instance of the given entity class with the given identifier, assuming that the instance exists.
     *You should not use this method to determine if an instance exists (use get() instead). Use this only to retrieve an instance that you assume exists, where non-existence would be an actual error.
     *
     * @param clazz a persistent class
     * @param id a valid identifier of an existing persistent instance of the class
     * @return the persistent instance or proxy
     * @throws HibernateException
     */
	Object load(Class<?> clazz, Serializable id) throws HibernateException;

}


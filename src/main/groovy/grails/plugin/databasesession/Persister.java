package grails.plugin.databasesession;

import java.util.List;

/**
 * @author Burt Beckwith
 */
public interface Persister {

	/**
	 * Retrieve an attribute value.
	 * @param sessionId the session id
	 * @param name the attribute name
	 * @return the value or null
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	Object getAttribute(String sessionId, String name) throws InvalidatedSessionException;

	/**
	 * Store an attribute value.
	 * @param sessionId the session id
	 * @param name the attribute name
	 * @param value the value
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	void setAttribute(String sessionId, String name, Object value) throws InvalidatedSessionException;

	/**
	 * Delete a persistent attribute value.
	 * @param sessionId the session id
	 * @param name the attribute name
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	void removeAttribute(String sessionId, String name) throws InvalidatedSessionException;

	/**
	 * Get all attribute names for the session.
	 * @param sessionId the session id
	 * @return the names (never null, may be empty)
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	List<String> getAttributeNames(String sessionId) throws InvalidatedSessionException;

	/**
	 * Delete a session and its attributes.
	 * @param sessionId the session id
	 */
	void invalidate(String sessionId);

	/**
	 * Register a new persistent session.
	 * @param sessionId the session id
	 */
	void create(String sessionId);

	/**
	 * Get the last access time.
	 * @param sessionId the session id
	 * @return the time
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	long getLastAccessedTime(String sessionId) throws InvalidatedSessionException;

	/**
    * Set the maximum time interval, in seconds, between client requests
    * before the servlet container will invalidate the session.  A negative
    * time indicates that the session should never time out.
    *
	 * @param sessionId the session id
	 * @param interval the interval seconds
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	void setMaxInactiveInterval(String sessionId, int interval) throws InvalidatedSessionException;

	/**
    * Set the maximum time interval, in seconds, between client requests
    * before the servlet container will invalidate the session.  A negative
    * time indicates that the session should never time out.
    *
	 * @param sessionId the session id
	 * @return the interval seconds
	 * @throws InvalidatedSessionException an error if the session is invalid
	 */
	int getMaxInactiveInterval(String sessionId) throws InvalidatedSessionException;

	/**
	 * Check if the session is valid.
	 * @param sessionId the session id
	 * @return true if the session exists and hasn't been invalidated
	 */
	boolean isValid(String sessionId);
}

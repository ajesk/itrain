package io.acode.itrain.db;


public interface HibernateConnection extends Connection {
    /**
     * Pass in any of the models set up for the ORM to save them to the
     * @param object
     */
    void save(Object object);

    /**
     * update the current object in the db if it exists
     * @param object
     */
    void update(Object object);

    /**
     * delete the current object in the db if it exists. Does not require all of the values to work only the ID needs
     * to be set
     * @param object
     */
    void delete(Object object);


    Object get(Class clas);

    /**
     * get an object based upon its class and id.
     * @param id
     * @param clas
     * @return
     */
    Object get(int id, Class clas);
}

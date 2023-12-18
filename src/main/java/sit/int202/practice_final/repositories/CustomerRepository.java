package sit.int202.practice_final.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import sit.int202.practice_final.entities.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public Customer find(String customerNumber){
        return getEntityManager().find(Customer.class,customerNumber);
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER");
        query.setParameter("user_account", name);
        Customer customer = null;
        try {
            customer = (Customer) query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
        if (customer == null) {
            return null;
        }
        return customer;
    }

    public List<Customer> findAll() {
        return getEntityManager().createQuery("select c from Customer c").getResultList();
    }

    public boolean insert(Customer customer) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(String customerNumber){
        EntityManager entityManager = getEntityManager();
        Customer customer = find(customerNumber);
        if (customer != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Customer newCustomer) {
        if (newCustomer != null) {
            try {
                EntityManager entityManager = getEntityManager();
                Customer customer = find(newCustomer.getCustomerName());
                if (customer != null) {
                    entityManager.getTransaction().begin();
                    //set all attributes office with newOffice (DIY)
                    customer.setCustomerName(newCustomer.getCustomerName());
                    customer.setContactFirstName(newCustomer.getContactFirstName());
                    customer.setContactLastName(newCustomer.getContactLastName());
                    customer.setPhone(newCustomer.getPhone());
                    customer.setAddressLine1(newCustomer.getAddressLine1());
                    customer.setAddressLine2(newCustomer.getAddressLine2());
                    customer.setCity(newCustomer.getCity());
                    customer.setState(newCustomer.getState());
                    customer.setPostalCode(newCustomer.getPostalCode());
                    customer.setCountry(newCustomer.getCountry());
                    customer.setCreditLimit(newCustomer.getCreditLimit());
                }
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}


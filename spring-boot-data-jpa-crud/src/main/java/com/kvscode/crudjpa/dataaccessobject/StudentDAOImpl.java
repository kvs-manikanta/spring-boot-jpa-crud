package com.kvscode.crudjpa.dataaccessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.kvscode.crudjpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id)
    {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll()
    {
        //Create the qyery using JPQL
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);

        //return the result

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName)
    {
        TypedQuery<Student> theQuery=
        entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int theId)
    {
        Student thestudent=entityManager.find(Student.class,theId);
        entityManager.remove(thestudent);
    }
    
}

package com.session.nipuna.session_nipuna.repository;

import com.session.nipuna.session_nipuna.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    boolean existsByNameAndIsActive(String name, Boolean status);           // <-------------------- Query Methods

    @Query("SELECT s FROM Student s WHERE s.name = :name AND s.isActive = :status")
    List<Student> findByNameAndIsActive(String name, Boolean status);       // <-------------------- JPQL query ( operate entity object )

    @Query(value = "SELECT * FROM student WHERE name = :name AND isActive = :status", nativeQuery = true)
    List<Student> findByNameAndIsActiveNative(String name, Boolean status); // <------------------- Native SQL query    ( operate database table )
}

package com.ictec.buisness.repo;

import com.ictec.buisness.httpentities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BusinessRepo extends JpaRepository<Business, Long> {
    @Query("SELECT b FROM Business b WHERE b.name LIKE %:end")
    List<Business> findByNameEndsWith(@Param("end") String end);
}
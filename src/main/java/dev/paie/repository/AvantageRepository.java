package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.paie.entite.Avantage;

public interface AvantageRepository extends JpaRepository<Avantage, Integer> {
	
	//@Query("select a from Avantage a where a.code = :code")
	List<Avantage> findByCode(String code);

}

package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.paie.entite.Avantage;
import dev.paie.entite.RemunerationEmploye;

public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Integer> {
	

}

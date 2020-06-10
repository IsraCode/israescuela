package com.example.israel1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.israel1.model.AlumnoModel;

import java.util.UUID;

public interface AlumnoRepository extends JpaRepository<AlumnoModel, UUID>{
	
}

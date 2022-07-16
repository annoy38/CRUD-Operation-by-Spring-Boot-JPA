package com.CRUDoperationInSpring.CRUDoperation.repositoryPACK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUDoperationInSpring.CRUDoperation.studentPACK.studentClass;

@Repository
public interface IstudentRepository extends JpaRepository<studentClass, String>{

	List<studentClass> findBysSection(String sSection);

	
}

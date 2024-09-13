//package com.example.repository.custom.impl;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//
//import com.example.builder.BuildingSearchBuilder;
//import com.example.repository.BuildingRepository;
//import com.example.repository.entity.BuildingEntity;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
//
//@Repository
//@Primary
//public class BuildingRepositoryImpl  {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	//@Override
//	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
//		// JPQL : JPA Query L
////		String sql = "FROM Building b ";
////		Query query = entityManager.createQuery(sql, BuildingEntity.class);
////		return query.getResultList();
//
//		// sql native
//		String sql = "SELECT * FROM building b WHERE b.name like '%building%' ";
//		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
//		return query.getResultList();
//	}
//
//	
//
//}

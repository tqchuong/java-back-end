package com.example.repository.custom;

import java.util.List;



import com.example.builder.BuildingSearchBuilder;
import com.example.repository.entity.BuildingEntity;


public interface BuildingRepositoryCustom {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}

package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.builder.BuildingSearchBuilder;
import com.example.converter.BuildingDTOconverter;
import com.example.converter.BuildingSearchBuilderConverter;
import com.example.model.BuildingDTO;
import com.example.repository.BuildingRepository;
import com.example.repository.entity.BuildingEntity;
import com.example.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingDTOconverter buildingDTOconverter;

	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@Override
	public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingsearchBuilder(params, typeCode);
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO building = buildingDTOconverter.toBuildingDTO(item);
			result.add(building);
		}
		return result;
	}

}

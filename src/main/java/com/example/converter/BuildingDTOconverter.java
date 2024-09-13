package com.example.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.BuildingDTO;
import com.example.repository.entity.BuildingEntity;
import com.example.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOconverter {

	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setAddress(item.getStreet() + ", " + item.getWard() + "," + item.getDistrict().getName());
		List<RentAreaEntity> rentAreas = item.getItems();
		String rentResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(rentResult);
		return building;
	}

}

package com.example.repository;

import java.util.List;

import com.example.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> getValueByBuilding(Long id);

}

package com.example.repository;

import com.example.repository.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findNameById(Long id);

}

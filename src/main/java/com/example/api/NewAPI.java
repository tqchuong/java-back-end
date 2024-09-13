package com.example.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BuildingDTO;
import com.example.repository.BuildingRepository;
import com.example.repository.entity.BuildingEntity;
import com.example.service.BuildingService;

@Transactional
@RestController
@PropertySource("classpath:application.properties")
public class NewAPI {
	@Autowired
	private BuildingService buidingService;

	@Autowired
	private BuildingRepository buildingRepository;

	@GetMapping(value = "/test/")

	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
			@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buidingService.findAll(params, typeCode);
		return result;
	}

	@GetMapping(value = "/test/{name}")
	public BuildingDTO getBuildingById(@PathVariable String name) {
		BuildingDTO result = new BuildingDTO();
		List<BuildingEntity> building = buildingRepository.findByNameContaining(name);
		return result;
	}

//	public void valiDate(BuildingDTO buildingDTO) {
//		if (buildingDTO.getName() == null || buildingDTO.getName().equals("")
//				|| buildingDTO.getNumberOfBasement() == null) {
//			throw new FieldRequiredException("name of numberofbasement is null");
//		}
//	}

//	@PostMapping(value = "/test")
//
//	public void testAPI1(@RequestBody BuildingDTO buildingDTO) {
//		System.out.println("ok");
//	}

	@DeleteMapping(value = "/test{id}")
	public void deleteBuilding(@PathVariable Integer id) {
		System.out.println("da xoa" + id);

	}

}

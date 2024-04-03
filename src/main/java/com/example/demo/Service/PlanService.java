package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.PlanDto;

@Service
public interface PlanService {

	PlanDto createPlan(PlanDto planDto);

	PlanDto getPlanById(Long id);

	List<PlanDto> getAllPlan();

	

}

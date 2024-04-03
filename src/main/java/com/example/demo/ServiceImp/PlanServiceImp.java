package com.example.demo.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.demo.Dto.PlanDto;
import com.example.demo.Repository.PlanRepo;
import com.example.demo.Service.PlanService;
import com.example.demo.entity.Plan;


@Service
public class PlanServiceImp implements PlanService {

    private final PlanRepo planRepository;

    public PlanServiceImp(PlanRepo planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public PlanDto createPlan(PlanDto planDto) {
        Plan savedPlan = planRepository.save(mapDtoToEntity(planDto));
        return mapEntityToDto(savedPlan);
    }

    @Override
    public PlanDto getPlanById(Long id) {
        Plan plan = planRepository.findById(id).orElse(null);
        if (plan != null) {
            return mapEntityToDto(plan);
        } else {
            return null; 
        }
    }
    private Plan mapDtoToEntity(PlanDto planDto) {
        Plan plan = new Plan();
        plan.setPlanprice(planDto.getPlanprice());
        plan.setPlandetails(planDto.getPlandetails());
        plan.setPlanname(planDto.getPlanname());
        return plan;
    }

    private PlanDto mapEntityToDto(Plan plan) {
        PlanDto planDto = new PlanDto();
        planDto.setPlanid(plan.getPlanid());
        planDto.setPlanprice(plan.getPlanprice());
        planDto.setPlandetails(plan.getPlandetails());
        planDto.setPlanname(plan.getPlanname());
        return planDto;
    }


	@Override
	public List<PlanDto> getAllPlan() {
		List<Plan> plan =planRepository.findAll();
        return plan.stream()
                        .map(this::mapEntityToDto)
                        .collect(Collectors.toList());
	}
}

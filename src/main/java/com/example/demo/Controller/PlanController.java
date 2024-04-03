package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Dto.PlanDto;
import com.example.demo.Service.PlanService;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

	 private PlanService planService;
	 
	 public PlanController(PlanService planService) {
		 this.planService = planService;
	 }
	 
	 @PostMapping
	 public ResponseEntity<PlanDto> createPlan(@RequestBody PlanDto planDto){
		 PlanDto createdPlan = planService.createPlan(planDto);
	        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
		 
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<PlanDto> getPlanById(@PathVariable Long id){
		 PlanDto planDto=planService.getPlanById(id);
		 if(planDto!=null) {
			 return new ResponseEntity<>(planDto, HttpStatus.OK);
		 }else
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	 }
	 @GetMapping
	    public ResponseEntity<List<PlanDto>> getAllPlan() {
	        List<PlanDto> plan = planService.getAllPlan();
	        return new ResponseEntity<>(plan, HttpStatus.OK);
	    }

	 
}

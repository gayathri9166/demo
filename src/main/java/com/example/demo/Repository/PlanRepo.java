package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long>{

}

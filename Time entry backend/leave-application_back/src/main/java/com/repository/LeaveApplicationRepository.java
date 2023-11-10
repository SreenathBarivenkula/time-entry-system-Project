package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Leaveapplication;

public interface LeaveApplicationRepository extends JpaRepository<Leaveapplication, Long> {
}

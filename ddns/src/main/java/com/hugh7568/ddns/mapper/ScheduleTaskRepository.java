package com.hugh7568.ddns.mapper;

import com.hugh7568.ddns.bean.ScheduleTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ScheduleTaskMapper继承基类
 *
 * @author Hugh
 */
@Repository
public interface ScheduleTaskRepository extends JpaRepository<ScheduleTask, Integer> {
}
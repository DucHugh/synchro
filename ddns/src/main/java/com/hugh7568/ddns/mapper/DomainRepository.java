package com.hugh7568.ddns.mapper;

import com.hugh7568.ddns.bean.po.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hugh
 */
@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer> {
}

package org.ccs.app.core.academic.infra.repository;

import org.ccs.app.core.academic.domain.AcademicSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicScheduleRepository extends JpaRepository<AcademicSchedule, Long>, AcademicScheduleCustomRepository {


}

package com.codegym.case_study.reposiroty.RepoSub;

import com.codegym.case_study.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService,Long> {
}

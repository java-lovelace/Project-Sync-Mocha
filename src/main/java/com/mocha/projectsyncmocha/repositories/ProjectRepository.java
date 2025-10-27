package com.mocha.projectsyncmocha.repositories;

import com.mocha.projectsyncmocha.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}

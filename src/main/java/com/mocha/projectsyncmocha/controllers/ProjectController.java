package com.mocha.projectsyncmocha.controllers;

import com.mocha.projectsyncmocha.models.Project;
import com.mocha.projectsyncmocha.repositories.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {
    private final ProjectRepository repo;

    public ProjectController(ProjectRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Project> getAll(){
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Project> getProject(@PathVariable Long id){
        return repo.findById(id);
    }

    @PostMapping
    public Project save(@RequestBody Project project){
        return repo.save(project);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable Long id,
            @RequestBody Project projectDetails) {

        return repo.findById(id)
                .map(project -> {
                    if (projectDetails.getName() != null)
                        project.setName(projectDetails.getName());
                    if (projectDetails.getDescription() != null)
                        project.setDescription(projectDetails.getDescription());
                    if (projectDetails.getStatus() != null)
                        project.setStatus(projectDetails.getStatus());
                    if (projectDetails.getResponsible() != null)
                        project.setResponsible(projectDetails.getResponsible());
                    project = repo.save(project);
                    return ResponseEntity.ok(project);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}

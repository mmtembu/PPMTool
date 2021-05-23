package com.mmtembu.ppmtool.services;

import com.mmtembu.ppmtool.domain.Project;
import com.mmtembu.ppmtool.exceptions.ProjectIdException;
import com.mmtembu.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    //Saves a project object, if there's an error then it throws an exception
    public Project saveOrUpdateProject(Project project){
        //A lot of logic has to go in here
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception exception){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }

    //Finds a project, by a given ID. If it doesn't exist then it has to throw an exception
    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null)
            throw new ProjectIdException("Project ID '"+projectId.toUpperCase()+"' doesn't exist");
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Cannot find Project with ID '"+projectId+"'. This project does not exist.");
        }
        projectRepository.delete(project);
    }
}

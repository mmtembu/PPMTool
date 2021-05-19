package com.mmtembu.ppmtool.services;

import com.mmtembu.ppmtool.domain.Project;
import com.mmtembu.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project){
        //A lot of logic has to go in here
        return projectRepository.save(project);
    }
}

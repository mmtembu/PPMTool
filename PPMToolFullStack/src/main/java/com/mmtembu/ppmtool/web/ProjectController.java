package com.mmtembu.ppmtool.web;

import com.mmtembu.ppmtool.domain.Project;
import com.mmtembu.ppmtool.services.MapValidationErrorService;
import com.mmtembu.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    /**
     * Annotation @PostMapping allows POST requests
     * Takes a Project object as Request. Checks if the object is valid.
     * Saves the object in the projectService object and then returns the status code (e.g 200 OK, 400
     *  error) depending what the server returns.
     * @param project object which contains all the populated fields
     * @return status code
     */
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
//        if(errorMap != null) return errorMap;

//        Project project1 = this.projectService.saveOrUpdateProject(project);
        return errorMap != null ? errorMap : new ResponseEntity<Project>(this.projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }
}

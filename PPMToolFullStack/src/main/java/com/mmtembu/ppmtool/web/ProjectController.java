package com.mmtembu.ppmtool.web;

import com.mmtembu.ppmtool.domain.Project;
import com.mmtembu.ppmtool.services.MapValidationErrorService;
import com.mmtembu.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
     * Saves the object in the projectService object and then returns the status code (e.g 200 OK, 400 server
     *  error) depending what the server returns.
     * @param project object which contains all the populated fields
     * @return status code
     */
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        return errorMap != null ? errorMap : new ResponseEntity<Project>(this.projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }

    /**
     * Fetches an existing project by a given id, using GET Method
     * @param projectId id of the project that has to be fetched
     * @return returns the project and the OK status code
     */
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId.toUpperCase());
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }

//    @DeleteMapping("/{projectId}")
    @RequestMapping(
            value = "/{projectId}",
            produces = "application/json",
            method = {RequestMethod.DELETE}
    )
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectService.deleteProjectByIdentifier(projectId);
        return new ResponseEntity<String>("Project with ID: '"+projectId+"' was deleted", HttpStatus.OK);
    }
}

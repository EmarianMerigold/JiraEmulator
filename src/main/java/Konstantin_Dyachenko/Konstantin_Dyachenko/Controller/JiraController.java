package Konstantin_Dyachenko.Konstantin_Dyachenko.Controller;


import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.FieldsDTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.IssueRequestDTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.IssueUpdateDTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.Model.Issue;
import Konstantin_Dyachenko.Konstantin_Dyachenko.Repository.IssueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
public class JiraController {

    private final IssueRepository issueRepository = new IssueRepository();

    @PostMapping(value = "/rest/api/2/issue",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Issue> createIssue(@Valid @RequestBody IssueRequestDTO issueRequestDTO) {



        //String responseBody = "{ \"id\" : \"%s\"}";
        //String taskId = "1234";
       // responseBody = String.format(responseBody, taskId);

        Issue createdIssue = issueRepository.save(issue);
        return new ResponseEntity<>(createdIssue, HttpStatus.CREATED);
    }

    @GetMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Issue> getIssue(@PathVariable Long id) {

        Issue issue = issueRepository.findById(id);
        if (issue != null) {
            return new ResponseEntity<>(issue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Issue> editIssue(@PathVariable Long id, @Valid @RequestBody Issue issueRequest) {

        Issue existingIssue = issueRepository.findById(id);
        if (existingIssue != null) {
            issueRequest.setId(id);  // Ensure the ID remains the same
            issueRepository.save(issueRequest);  // Save updated issue
            return new ResponseEntity<>(issueRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteIssue(@PathVariable Long id) {
        issueRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


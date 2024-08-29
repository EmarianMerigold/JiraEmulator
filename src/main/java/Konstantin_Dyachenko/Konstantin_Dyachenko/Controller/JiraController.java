package Konstantin_Dyachenko.Konstantin_Dyachenko.Controller;


import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.IssueRequestDTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.IssueUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
public class JiraController {

    @PostMapping(value = "/rest/api/2/issue",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createIssue(@Valid @RequestBody IssueRequestDTO issueRequest) {

        String responseBody = "{ \"id\" : \"%s\"}";
        String taskId = "1234";

        responseBody = String.format(responseBody, taskId);

        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }

    @GetMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getIssue(@PathVariable String id) {

        String responseBody = "{ \"id\" : \"%s\"}";
        String taskId = "1234";
        responseBody = String.format(responseBody, taskId);

        return new ResponseEntity<String>(responseBody,HttpStatus.OK);
    }

    @PutMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editIssue(@PathVariable String id, @Valid @RequestBody IssueUpdateDTO issueUpdate) {

        String responseBody = "{ \"id\" : \"%s\"}";
        String taskId = "1234";
        responseBody = String.format(responseBody, taskId);

        return new ResponseEntity<>(responseBody,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteIssue(@PathVariable String id) {

        String responseBody = "{ \"id\" : \"%s\"}";
        String taskId = "1234";
        responseBody = String.format(responseBody, taskId);

        return new ResponseEntity<>(responseBody,HttpStatus.NO_CONTENT);
    }
}


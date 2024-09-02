package Konstantin_Dyachenko.Konstantin_Dyachenko.Controller;


import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.FieldsDTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.IssueRequestDTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.DTO.IssueUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@RestController
public class JiraController {

    // Хранилище для запросов. Интегрирована утилита ConcurrentHashMap для осуществления многопоточности
    private static final Map<String, IssueRequestDTO> issueStore = new ConcurrentHashMap<>();
    private final SecureRandom random = new SecureRandom();

    @PostMapping(value = "/rest/api/2/issue",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> createIssue(@Valid @RequestBody IssueRequestDTO issueRequest) {


        // Генерируем уникальный идентификатор задачи с использованием UUID
        String taskId = generateUniqueId();

        // Сохраняем запрос в HashMap
        issueStore.put(taskId, issueRequest);

        // Формируем тело ответа
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("id", taskId);
        responseBody.put("fields", issueRequest);

        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }

    @GetMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getIssue(@PathVariable String id) {

        IssueRequestDTO issueRequest = issueStore.get(id);

        if (issueRequest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Формируем тело ответа
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("id", id);
        responseBody.put("fields", issueRequest);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PutMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> editIssue(@PathVariable String id, @Valid @RequestBody IssueUpdateDTO issueUpdate) {

        IssueRequestDTO existingIssue = issueStore.get(id);

        if (existingIssue == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Получаем объект FieldsDTO из существующей задачи
        FieldsDTO existingFields = existingIssue.getFields();

        // Обновляем только те поля, которые присутствуют в IssueUpdateDTO
        if (issueUpdate.getSummary() != null) {
            existingFields.setSummary(issueUpdate.getSummary());
        }
        if (issueUpdate.getDescription() != null) {
            existingFields.setDescription(issueUpdate.getDescription());
        }
        if (issueUpdate.getIssuetype() != null) {
            existingFields.setIssuetype(issueUpdate.getIssuetype());
        }
        if (issueUpdate.getPriority() != null) {
            existingFields.setPriority(issueUpdate.getPriority());
        }

        // Сохраняем обновленный FieldsDTO обратно в IssueRequestDTO
        existingIssue.setFields(existingFields);
        issueStore.put(id, existingIssue);

        // Формируем тело ответа
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("id", id);
        responseBody.put("fields", existingFields);

        return new ResponseEntity<>(responseBody, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/rest/api/2/issue/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteIssue(@PathVariable String id) {

        if (!issueStore.containsKey(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Удаляем задачу из хранилища
        issueStore.remove(id);

        // Формируем тело ответа
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("id", id);

        return new ResponseEntity<>(responseBody, HttpStatus.NO_CONTENT);
    }

    // Генерация случайного 6-значного числа для использования в id
    private String generateUniqueId() {
        int id = 100000 + random.nextInt(900000);
        return String.valueOf(id);
    }

}


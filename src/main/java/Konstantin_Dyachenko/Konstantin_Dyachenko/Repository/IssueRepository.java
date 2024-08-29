package Konstantin_Dyachenko.Konstantin_Dyachenko.Repository;

import Konstantin_Dyachenko.Konstantin_Dyachenko.Model.Issue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class IssueRepository {

    private final Map<Long, Issue> issues = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public Issue save(Issue issue) {
        Long id = counter.incrementAndGet();
        issue.setId(id);
        issues.put(id, issue);
        return issue;
    }

    public Issue findById(Long id) {
        return issues.get(id);
    }

    public void delete(Long id) {
        issues.remove(id);
    }

    public Map<Long, Issue> findAll() {
        return issues;
    }
}

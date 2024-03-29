package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.IssueRequest;
import com.example.main.DTO.response.workspace.IssueResponse;
import com.example.main.service.workspace.IssueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {
    @Autowired
    private IssueService issueService;


    @GetMapping("")
    public List<IssueResponse> getAllIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/{id}/issues")
    public List<IssueResponse> getAllWorkspaceIssues(@PathVariable Long id) {
        return issueService.getAllWorkspaceIssues(id);
    }

    @GetMapping("/{id}")
    public IssueResponse getIssue(@PathVariable Long id){
        return issueService.getIssue(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateIssue(String deadlined, IssueRequest issueRequest){
        IssueResponse issueResponse = issueService.updateIssue(deadlined, issueRequest);
        return ResponseEntity.ok(issueResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postIssue(String deadlined, IssueRequest issueRequest){
        IssueResponse issueResponse = issueService.createIssue(deadlined, issueRequest);
        return ResponseEntity.ok(issueResponse);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteIssue(@PathVariable Long id){
        issueService.deleteIssue(id);
        return ResponseEntity.ok().build();
    }
}

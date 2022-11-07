package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.IssueRequest;
import com.example.main.DTO.response.workspace.IssueResponse;
import com.example.main.entity.workspace.Issue;
import com.example.main.repository.workspace.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<IssueResponse> getAllIssues() {
        return issueRepository.findAll().stream()
                .map(IssueResponse::new)
                .collect(Collectors.toList());
    }

    public IssueResponse getIssue(Long id){
        Issue issue = null;
        if(issueRepository.existsById(id)) {
            issue = issueRepository.findById(id).get();
        }
        return new IssueResponse(issue);

    }

    public IssueResponse createIssue(IssueRequest issueRequest){
        Issue issue = Issue.builder()
                .issueId(issueRequest.getIssueId())
                //.profileIssuesSet(issueRequest.getProfileIssuesSet())
                //TODO: SPRAWDIZĆ CZY BUILDER TWORZY SAM profileIssuesSet
                .issueName(issueRequest.getIssueName())
                .workspaceId(issueRequest.getWorkspaceId())
                .deadline(issueRequest.getDeadline())
                .state(issueRequest.getState())
                //.statesSet(issueRequest.getStates())
                //TODO: SPRAWDIZĆ CZY BUILDER TWORZY SAM statesSet
                .build();
        issueRepository.save(issue);
        return new IssueResponse(issue);
    }

    public IssueResponse updateIssue(IssueRequest issueRequest){
        Issue issue = null;
        if(issueRepository.existsById(issueRequest.getIssueId())) {
            issue = issueRepository.findById(issueRequest.getIssueId()).get();
            issue.setIssueName(issue.getIssueName());
            issue.setProfileIssuesSet(issueRequest.getProfileIssuesSet());
            issue.setState(issueRequest.getState());
            issue.setDeadline(issueRequest.getDeadline());
            issue.setStatesSet(issueRequest.getStates());
            issueRepository.save(issue);
        }
        return new IssueResponse(issue);
    }

    public void deleteIssue(Long id){
        if(issueRepository.existsById(id)) {
            Issue issue = issueRepository.findById(id).get();
            issueRepository.delete(issue);
        }
    }

}

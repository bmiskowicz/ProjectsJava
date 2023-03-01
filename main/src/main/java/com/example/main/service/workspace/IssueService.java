package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.IssueRequest;
import com.example.main.DTO.response.workspace.IssueResponse;
import com.example.main.entity.workspace.Issue;
import com.example.main.entity.workspace.ProfileIssues;
import com.example.main.repository.workspace.IssueRepository;
import com.example.main.repository.workspace.ProfileIssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {
    final static DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private ProfileIssuesRepository profileIssuesRepository;

    public IssueResponse getIssue(Long id) {
        Issue issue = null;
        if(issueRepository.existsById(id)) {
            issue = issueRepository.findById(id).get();
        }
        return new IssueResponse(issue);
    }

    public List<IssueResponse> getAllIssues() {
        return issueRepository.findAll().stream()
                .map(IssueResponse::new)
                .collect(Collectors.toList());
    }

    public List<IssueResponse> getAllWorkspaceIssues(Long along) {
        return issueRepository.findAllByWorkspaceId(along).stream()
                .map(IssueResponse::new)
                .collect(Collectors.toList());
    }



    public IssueResponse createIssue(String date, IssueRequest issueRequest){
        LocalDateTime date2 = LocalDateTime.parse(date, formatter);
        ZonedDateTime result = date2.atZone(ZoneId.of("Europe/Warsaw"));

        Issue issue = Issue.builder()
                .issueName(issueRequest.getIssueName())
                .workspaceId(issueRequest.getWorkspaceId())
                .deadline(result)
                .build();
        issueRepository.save(issue);
        return new IssueResponse(issue);
    }

    public IssueResponse updateIssue(String date, IssueRequest issueRequest){
        LocalDateTime date2 = LocalDateTime.parse(date, formatter);
        ZonedDateTime result = date2.atZone(ZoneId.of("Europe/Warsaw"));
        Issue issue = null;
        if(issueRepository.existsById(issueRequest.getIssueId())) {
            issue = issueRepository.findById(issueRequest.getIssueId()).get();
            issue.setIssueName(issue.getIssueName());
            issue.setState(issueRequest.getState());
            issue.setDeadline(result);
            issueRepository.save(issue);
        }
        return new IssueResponse(issue);
    }

    public void deleteIssue(Long id){
        if(issueRepository.existsById(id)) {
            Issue issue = issueRepository.findById(id).get();

            //deleting issues relations to profiles
            List<ProfileIssues> profileIssuesList = profileIssuesRepository.findAllByIssue(issue);
            profileIssuesRepository.deleteAll(profileIssuesList);

            issueRepository.delete(issue);
        }
    }

}

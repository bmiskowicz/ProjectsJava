package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.WorkspaceMembersRequest;
import com.example.main.DTO.response.workspace.WorkspaceMembersResponse;
import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Issue;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceMembers;
import com.example.main.repository.ProfileRepository;
import com.example.main.repository.workspace.IssueRepository;
import com.example.main.repository.workspace.WorkspaceMembersRepository;
import com.example.main.repository.workspace.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceMembersService {

    @Autowired
    private WorkspaceMembersRepository workspaceMembersRepository;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public List<WorkspaceMembersResponse> getAllWorkspaceMembers() {
        return workspaceMembersRepository.findAll().stream()
                .map(WorkspaceMembersResponse::new)
                .collect(Collectors.toList());
    }

    public List<WorkspaceMembersResponse> getAllWorkspaceMembersById(Long id) {
        Workspace workspace = workspaceRepository.findById(id).get();
        return workspaceMembersRepository.findAllByWorkspace(workspace).stream()
                .map(WorkspaceMembersResponse::new)
                .collect(Collectors.toList());
    }

    public WorkspaceMembersResponse getWorkspaceMembers(Long id){
        WorkspaceMembers workspaceMembers = null;
        if(workspaceMembersRepository.existsById(id)) {
            workspaceMembers = workspaceMembersRepository.findById(id).get();
        }
        return new WorkspaceMembersResponse(workspaceMembers);

    }

    public WorkspaceMembersResponse createWorkspaceMembers(WorkspaceMembersRequest workspaceMembersRequest){
        Profile profile = profileRepository.findById(workspaceMembersRequest.getProfileId()).get();
        Workspace workspace = workspaceRepository.findById(workspaceMembersRequest.getWorkspaceId()).get();

        WorkspaceMembers workspaceMembers = WorkspaceMembers.builder()
                .workspaceMembersId(workspaceMembersRequest.getWorkspaceMembersId())
                .workspace(workspace)
                .profile(profile)
                .role(workspaceMembersRequest.getRole())
                .build();
        workspaceMembersRepository.save(workspaceMembers);
        return new WorkspaceMembersResponse(workspaceMembers);
    }

    public WorkspaceMembersResponse updateWorkspaceMembers(WorkspaceMembersRequest workspaceMembersRequest, Long id){
        WorkspaceMembers workspaceMembers = null;
        if(workspaceMembersRepository.existsById(id)) {
            workspaceMembers = workspaceMembersRepository.findById(id).get();
            workspaceMembers.setRole(workspaceMembersRequest.getRole());
            workspaceMembersRepository.save(workspaceMembers);
        }
        return new WorkspaceMembersResponse(workspaceMembers);
    }

    public void deleteWorkspaceMembers(WorkspaceMembersRequest workspaceMembersRequest){
        Profile profile = profileRepository.findById(workspaceMembersRequest.getProfileId()).get();
        Workspace workspace = workspaceRepository.findById(workspaceMembersRequest.getWorkspaceId()).get();

        if(workspaceMembersRepository.existsByProfileAndWorkspace(profile, workspace)) {
            WorkspaceMembers workspaceMembers = workspaceMembersRepository.findByProfileAndWorkspace(profile, workspace).get();
            workspaceMembersRepository.delete(workspaceMembers);
        }
    }
}

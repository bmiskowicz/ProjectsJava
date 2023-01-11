package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.WorkspaceMembersRequest;
import com.example.main.DTO.response.workspace.WorkspaceMembersResponse;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceMembers;
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
        WorkspaceMembers workspaceMembers = WorkspaceMembers.builder()
                .workspaceMembersId(workspaceMembersRequest.getWorkspaceMembersId())
                .workspace(workspaceMembersRequest.getWorkspace())
                .profile(workspaceMembersRequest.getProfile())
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

    public void deleteWorkspaceMembers(Long id){
        if(workspaceMembersRepository.existsById(id)) {
            WorkspaceMembers workspaceMembers = workspaceMembersRepository.findById(id).get();
            workspaceMembersRepository.delete(workspaceMembers);
        }
    }
}

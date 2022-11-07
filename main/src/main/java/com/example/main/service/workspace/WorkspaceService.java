package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.WorkspaceRequest;
import com.example.main.DTO.response.workspace.WorkspaceResponse;
import com.example.main.entity.workspace.Workspace;
import com.example.main.repository.workspace.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public List<WorkspaceResponse> getAllWorkspaces() {
        return workspaceRepository.findAll().stream()
                .map(WorkspaceResponse::new)
                .collect(Collectors.toList());
    }

    public WorkspaceResponse getWorkspace(Long id){
        Workspace workspace = null;
        if(workspaceRepository.existsById(id)) {
            workspace = workspaceRepository.findById(id).get();
        }
        return new WorkspaceResponse(workspace);

    }

    public WorkspaceResponse createWorkspace(WorkspaceRequest workspaceRequest){
        Workspace workspace = Workspace.builder()
                .workspaceId(workspaceRequest.getWorkspaceId())
                .workspaceName(workspaceRequest.getWorkspaceName())
                .workspaceDescription(workspaceRequest.getWorkspaceDescription())
                //.workspaceMembersSet(workspaceRequest.getWorkspaceMembersSet())
                //TODO: Wiadomo
                .build();
        workspaceRepository.save(workspace);
        return new WorkspaceResponse(workspace);
    }

    public WorkspaceResponse updateWorkspace(WorkspaceRequest workspaceRequest){
        Workspace workspace = null;
        if(workspaceRepository.existsById(workspaceRequest.getWorkspaceId())) {
            workspace = workspaceRepository.findById(workspaceRequest.getWorkspaceId()).get();
            workspace.setWorkspaceName(workspaceRequest.getWorkspaceName());
            workspace.setWorkspaceDescription(workspaceRequest.getWorkspaceDescription());
            workspace.setWorkspaceMembersSet(workspaceRequest.getWorkspaceMembersSet());
            workspaceRepository.save(workspace);
        }
        return new WorkspaceResponse(workspace);
    }

    public void deleteWorkspace(Long id){
        if(workspaceRepository.existsById(id)) {
            Workspace workspace = workspaceRepository.findById(id).get();
            workspaceRepository.delete(workspace);
        }
    }
}

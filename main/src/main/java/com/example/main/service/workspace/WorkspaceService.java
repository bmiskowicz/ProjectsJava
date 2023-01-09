package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.WorkspaceRequest;
import com.example.main.DTO.response.workspace.WorkspaceResponse;
import com.example.main.config.security.JWTUtils;
import com.example.main.entity.Profile;
import com.example.main.entity.log.Login;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceMembers;
import com.example.main.repository.ProfileRepository;
import com.example.main.repository.log.LoginRepository;
import com.example.main.repository.workspace.WorkspaceMembersRepository;
import com.example.main.repository.workspace.WorkspaceRepository;
import com.example.main.util.WorkspaceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    WorkspaceMembersRepository workspaceMembersRepository;

    @Autowired
    JWTUtils jwtUtils;


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

    public WorkspaceResponse createWorkspace(WorkspaceRequest workspaceRequest, HttpServletRequest httpRequest){
        Workspace workspace = Workspace.builder()
                .workspaceName(workspaceRequest.getWorkspaceName())
                .workspaceDescription(workspaceRequest.getWorkspaceDescription())
                //.workspaceMembersSet(workspaceRequest.getWorkspaceMembersSet())
                //TODO: TODO: SPRAWDZIĆ CZY BUILDER TWORZY SAM workspaceMembersSet
                .build();
        String token = httpRequest.getHeader("Authorization");
        System.out.println(token);
        String username = jwtUtils.getUserNameFromJwtToken(token);
        Login login = loginRepository.findByUsername(username).get();
        Profile profile = profileRepository.findById(login.getLoginId()).get();
        WorkspaceMembers workspaceMembers = WorkspaceMembers.builder().workspace(workspace).role(WorkspaceRole.ADMIN).profile(profile).build();
        workspaceRepository.save(workspace);
        workspaceMembersRepository.save(workspaceMembers);
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

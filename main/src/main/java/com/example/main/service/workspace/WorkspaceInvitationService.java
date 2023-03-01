package com.example.main.service.workspace;

import com.example.main.DTO.request.workspace.WorkspaceInvitationRequest;
import com.example.main.DTO.response.workspace.WorkspaceInvitationResponse;
import com.example.main.entity.Profile;
import com.example.main.entity.log.Login;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceInvitation;
import com.example.main.repository.ProfileRepository;
import com.example.main.repository.log.LoginRepository;
import com.example.main.repository.workspace.WorkspaceInvitationRepository;
import com.example.main.repository.workspace.WorkspaceMembersRepository;
import com.example.main.repository.workspace.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceInvitationService {
    @Autowired
    private WorkspaceInvitationRepository workspaceInvitationRepository;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private WorkspaceMembersRepository workspaceMembersRepository;

    public List<WorkspaceInvitationResponse> getAllWorkspaceInvitations() {
        return workspaceInvitationRepository.findAll().stream()
                .map(WorkspaceInvitationResponse::new)
                .collect(Collectors.toList());
    }

    public List<WorkspaceInvitationResponse> getAllWorkspaceInvitationsByWorkspace(Long along) {
        Workspace workspace = workspaceRepository.findById(along).get();
        return workspaceInvitationRepository.findAllByWorkspace(workspace).stream()
                .map(WorkspaceInvitationResponse::new)
                .collect(Collectors.toList());
    }

    public List<WorkspaceInvitationResponse> getAllWorkspaceInvitationsByProfile(Long along) {
        Profile profile = profileRepository.findById(along).get();
        return workspaceInvitationRepository.findAllByProfile(profile).stream()
                .map(WorkspaceInvitationResponse::new)
                .collect(Collectors.toList());
    }

    public WorkspaceInvitationResponse getWorkspaceInvitation(Long id){
        WorkspaceInvitation workspaceInvitation = null;
        if(workspaceInvitationRepository.existsById(id)) {
            workspaceInvitation = workspaceInvitationRepository.findById(id).get();
        }
        return new WorkspaceInvitationResponse(workspaceInvitation);

    }

    public WorkspaceInvitationResponse createWorkspaceInvitation(WorkspaceInvitationRequest workspaceInvitationRequest){

        Login login = loginRepository.findByUsername(workspaceInvitationRequest.getUsername()).get();
        Profile profile = profileRepository.findByLogin(login).get();
        Workspace workspace = workspaceRepository.findById(workspaceInvitationRequest.getWorkspaceId()).get();

        if(workspaceMembersRepository.existsByProfileAndWorkspace(profile, workspace)) return null;

        WorkspaceInvitation workspaceInvitation = WorkspaceInvitation.builder()
                .workspaceInvitationId(workspaceInvitationRequest.getWorkspaceInvitationId())
                .workspace(workspace)
                .profile(profile)
                .build();
        workspaceInvitationRepository.save(workspaceInvitation);
        return new WorkspaceInvitationResponse(workspaceInvitation);
    }


    public void deleteWorkspaceInvitation(Long along){
        if(workspaceInvitationRepository.existsById(along)) {
            WorkspaceInvitation workspaceInvitation = workspaceInvitationRepository.findById(along).get();
            workspaceInvitationRepository.delete(workspaceInvitation);
        }
    }

}

package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.WorkspaceInvitationRequest;
import com.example.main.DTO.response.workspace.WorkspaceInvitationResponse;
import com.example.main.repository.workspace.WorkspaceInvitationRepository;
import com.example.main.service.workspace.WorkspaceInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/invite")
public class WorkspaceInvitationController {
    @Autowired
    private WorkspaceInvitationService workspaceInvitationService;

    @GetMapping("")
    public List<WorkspaceInvitationResponse> getAllWorkspaceInvitation() {
        return workspaceInvitationService.getAllWorkspaceInvitations();
    }

    @GetMapping("/profile/{id}")
    public List<WorkspaceInvitationResponse> getWorkspaceInvitationsByProfile(@PathVariable Long id){
        return workspaceInvitationService.getAllWorkspaceInvitationsByProfile(id);
    }

    @GetMapping("/workspace/{id}")
    public List<WorkspaceInvitationResponse> getWorkspaceInvitationsByWorkspace(@PathVariable Long id){
        return workspaceInvitationService.getAllWorkspaceInvitationsByWorkspace(id);
    }

    @GetMapping("/{id}")
    public WorkspaceInvitationResponse getWorkspaceInvitation(@PathVariable Long id){
        return workspaceInvitationService.getWorkspaceInvitation(id);
    }

    @PostMapping("")
    public ResponseEntity<?> postWorkspaceInvitation(WorkspaceInvitationRequest workspaceInvitationRequest){
        WorkspaceInvitationResponse workspaceInvitationResponse = workspaceInvitationService.createWorkspaceInvitation(workspaceInvitationRequest);
        return ResponseEntity.ok(workspaceInvitationResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWorkspaceInvitation(@PathVariable Long id){
        workspaceInvitationService.deleteWorkspaceInvitation(id);
        return ResponseEntity.ok().build();
    }
}

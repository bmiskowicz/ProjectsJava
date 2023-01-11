package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.WorkspaceMembersRequest;
import com.example.main.DTO.response.workspace.WorkspaceMembersResponse;
import com.example.main.service.workspace.WorkspaceMembersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/members")
public class WorkspaceMembersController {

    @Autowired
    private WorkspaceMembersService workspaceMembersService;


    @GetMapping("")
    public List<WorkspaceMembersResponse> getAllWorkspaceMembers() {
        return workspaceMembersService.getAllWorkspaceMembers();
    }

    @GetMapping("/workspace/{id}")
    public List<WorkspaceMembersResponse> getAllWorkspaceMembers(@PathVariable Long id) {
        return workspaceMembersService.getAllWorkspaceMembersById(id);
    }

    @GetMapping("/{id}")
    public WorkspaceMembersResponse getWorkspaceMembers(@PathVariable Long id){
        return workspaceMembersService.getWorkspaceMembers(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateWorkspaceMembers(WorkspaceMembersRequest workspaceMembersRequest, @PathVariable Long id){
        WorkspaceMembersResponse workspaceMembersResponse = workspaceMembersService.updateWorkspaceMembers(workspaceMembersRequest, id);
        return ResponseEntity.ok(workspaceMembersResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postWorkspaceMembers(WorkspaceMembersRequest workspaceMembersRequest){
        WorkspaceMembersResponse workspaceMembersResponse = workspaceMembersService.createWorkspaceMembers(workspaceMembersRequest);
        return ResponseEntity.ok(workspaceMembersResponse);
    }
}

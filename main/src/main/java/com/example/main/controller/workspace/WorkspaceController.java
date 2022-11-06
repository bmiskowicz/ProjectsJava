package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.WorkspaceRequest;
import com.example.main.DTO.response.workspace.WorkspaceResponse;
import com.example.main.service.workspace.WorkspaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;


    @GetMapping("")
    public List<WorkspaceResponse> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public WorkspaceResponse getWorkspace(@PathVariable Long id){
        return workspaceService.getWorkspace(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateWorkspace(WorkspaceRequest workspaceRequest){
        WorkspaceResponse workspaceResponse = workspaceService.updateWorkspace(workspaceRequest);
        return ResponseEntity.ok(workspaceResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postWorkspace(WorkspaceRequest workspaceRequest){
        WorkspaceResponse workspaceResponse = workspaceService.createWorkspace(workspaceRequest);
        return ResponseEntity.ok(workspaceResponse);
    }
}

package com.example.main.controller.workspace;

import com.example.main.DTO.request.workspace.WorkspaceRequest;
import com.example.main.DTO.response.workspace.WorkspaceResponse;
import com.example.main.service.workspace.WorkspaceService;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Transactional
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

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteWorkspace(@PathVariable Long id){
        workspaceService.deleteWorkspace(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/post")
    public ResponseEntity<?> postWorkspace(WorkspaceRequest workspaceRequest, HttpServletRequest httpRequest){
        WorkspaceResponse workspaceResponse = workspaceService.createWorkspace(workspaceRequest, httpRequest);
        return ResponseEntity.ok(workspaceResponse);
    }
}

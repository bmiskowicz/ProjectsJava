CREATE SEQUENCE IF NOT EXISTS workspaces.hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE workspaces.workspace_invitations
(
    workspace_invitation_id BIGINT NOT NULL,
    profile_id              BIGINT,
    workspace_id            BIGINT,
    CONSTRAINT pk_workspaceinvitations PRIMARY KEY (workspace_invitation_id)
);

ALTER TABLE workspaces.workspace_invitations
    ADD CONSTRAINT FK_WORKSPACEINVITATIONS_ON_PROFILEID FOREIGN KEY (profile_id) REFERENCES profiles.profile (profile_id);

ALTER TABLE workspaces.workspace_invitations
    ADD CONSTRAINT FK_WORKSPACEINVITATIONS_ON_WORKSPACE FOREIGN KEY (workspace_id) REFERENCES workspaces.workspace (workspace_id);

DROP SEQUENCE workspaces.auto_gen3 CASCADE;

DROP SEQUENCE workspaces.auto_gen4 CASCADE;
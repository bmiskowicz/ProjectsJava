package com.example.main.DTO.response.user;

import com.example.main.entity.Profile;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.ZonedDateTime;

@Setter
@Getter
public class ProfileResponse {
    private Long id;
    private String username;

    @Nullable
    private Byte icon=null;
    private ZonedDateTime creationDate;

    public ProfileResponse(Profile profile) {
        this.id = profile.getProfileId();
        this.username = profile.getUsername();
        try{
            this.icon = profile.getIcon();
        }catch (NullPointerException e){};
        this.creationDate = profile.getCreationDate();
    }
}

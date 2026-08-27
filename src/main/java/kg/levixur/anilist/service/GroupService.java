package kg.levixur.anilist.service;

import kg.levixur.anilist.dto.group.GroupResponse;

public interface GroupService {
    GroupResponse getGroupById(Long id);
}

package kg.levixur.anilist.controller;

import kg.levixur.anilist.dto.group.GroupResponse;
import kg.levixur.anilist.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/{id}")
    public GroupResponse getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }
}

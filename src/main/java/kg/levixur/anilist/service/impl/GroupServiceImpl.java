package kg.levixur.anilist.service.impl;

import kg.levixur.anilist.dto.group.GroupResponse;
import kg.levixur.anilist.entity.Group;
import kg.levixur.anilist.mapper.GroupMapper;
import kg.levixur.anilist.repository.GroupRepository;
import kg.levixur.anilist.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public GroupResponse getGroupById(Long id) {
        Group group = groupRepository.findByIdWithStudents(id)
                .orElseThrow(() -> new RuntimeException("Группа с ID " + id + " не найдена1"));
        return groupMapper.toResponse(group);
    }
}

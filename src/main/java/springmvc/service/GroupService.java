package springmvc.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import springmvc.model.Group;
import springmvc.repositories.GroupRepositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {

    private final GroupRepositories groupRepositories;

    public GroupService(GroupRepositories groupRepositories) {
        this.groupRepositories = groupRepositories;
    }
//
//    public void saveGroup(Group group) {
//        groupRepositories.saveGroup(group);
//    }
//
//    public Optional<Group> findGroupById(UUID id) throws NotFoundException {
//        return Optional.ofNullable(findGroupById(id)).orElseThrow(() -> new NotFoundException("not found"));
//
//    }
//
//    public void deleteGroupByID(UUID id) throws NotFoundException {
//        Group group = findGroupById(id).orElseThrow(() -> new NotFoundException(String.format("Group is id %s not found", id)));
//        System.out.println(group);
//        groupRepositories.removeGroupById(id);
//    }
//
//    public List<Group> groups() {
//        return groupRepositories.getAllGroup();
//    }
//
//    public void updateGroupByID(Group newGroup, UUID id) throws NotFoundException {
//        Group group = findGroupById(id).orElseThrow(() -> new NotFoundException("not found"));
//        String groupName = group.getGroupName();
//        String newGroupName = newGroup.getGroupName();
//
//        if (!Objects.equals(group, newGroupName)) {
//            group.setGroupName(newGroupName);
//        }


    public void saveGroup(Group group) {
        groupRepositories.saveGroup(group);
    }


    public List<Group> getGroups(UUID id) {
        return groupRepositories.getGroups(id);
    }


    public Group getGroupById(UUID id) {
        return groupRepositories.getGroupById(id);
    }


    public void deleteGroup(UUID id) {
        groupRepositories.deleteGroup(id);
    }

    public void updateGroup(UUID id, Group updatedGroup) {
        groupRepositories.updateGroup(id, updatedGroup);
    }


    public List<Group> getGroupByCompanyId(UUID id) {
        return groupRepositories.getGroupByCompanyId(id);
    }
}



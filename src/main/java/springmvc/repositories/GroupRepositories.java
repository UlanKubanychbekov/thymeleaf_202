package springmvc.repositories;

import javassist.NotFoundException;
import org.springframework.stereotype.Repository;
import springmvc.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class GroupRepositories {
    private final EntityManager entityManager;

    public GroupRepositories(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }

    public void saveGroup(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
    }

    public Optional<Group> findGroupById(UUID id) {
        return Optional.ofNullable(entityManager.find(Group.class, id));
    }


    public void removeGroupById(UUID uuid) throws NotFoundException {
        findGroupById(uuid).orElseThrow(()-> new NotFoundException("Group is id %s not found"));
        entityManager.remove(uuid);


    }


    public List<Group> getAllGroup() {
         List<Group> groups = entityManager.createQuery("select c from Group c", Group.class).getResultList();
         return groups;
    }


    public void updateGroup(UUID id, Group group) throws NotFoundException {
        findGroupById(id).orElseThrow(()->new NotFoundException("not found Group"));
        entityManager.merge(group);

    }
}

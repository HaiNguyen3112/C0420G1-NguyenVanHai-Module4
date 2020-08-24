package repository;

import model.Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailRepositoryImpl implements EmailRepository {
    Map<Integer,Email> emailMap = new HashMap<>();
    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emailMap.values());
    }

    @Override
    public void save(Email email) {
    emailMap.put(email.getId(),email);
    }

    @Override
    public void delete(int id) {
    emailMap.remove(id);
    }

    @Override
    public Email findById(int id) {
        return emailMap.get(id);
    }
}

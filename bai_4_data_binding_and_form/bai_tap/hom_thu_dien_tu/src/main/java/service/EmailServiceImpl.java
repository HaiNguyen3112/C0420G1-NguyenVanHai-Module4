package service;

import model.Email;
import repository.EmailRepositoryImpl;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    EmailRepositoryImpl emailList = new EmailRepositoryImpl();
    @Override
    public List<Email> findAll() {
        return emailList.findAll();
    }

    @Override
    public void save(Email email) {
        emailList.save(email);
    }

    @Override
    public void delete(int id) {
        emailList.delete(id);
    }

    @Override
    public Email findById(int id) {
        return emailList.findById(id);
    }
}

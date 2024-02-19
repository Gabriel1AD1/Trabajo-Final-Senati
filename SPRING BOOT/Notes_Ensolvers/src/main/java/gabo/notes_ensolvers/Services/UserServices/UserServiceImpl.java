package gabo.notes_ensolvers.Services;

import gabo.notes_ensolvers.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserServices{


    @Autowired
    UserRepository repository;

    @Override
    public Optional getUser() {
        return Optional.empty();
    }

    @Override
    public Optional getUserByID() {
        return Optional.empty();
    }
}

package id.tokoonderdil.study.springbootmybatis.controller;

import id.tokoonderdil.study.springbootmybatis.mapper.UsersMapper;
import id.tokoonderdil.study.springbootmybatis.model.Users;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersController {

    private UsersMapper usersMapper;

    public UsersController(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @GetMapping("/{id}")
    public List<Users> getById(@PathVariable(value = "id") int userId) {
        return usersMapper.findById(userId);
    }

    @PostMapping("/new")
    public void newUsers(@Valid @RequestBody Users users) {
        usersMapper.insert(users);
    }

    @PutMapping("/update/{id}")
    public void updateUsers(@PathVariable(value = "id") int userId, @Valid @RequestBody Users users) {
        Users newUser = new Users();
        newUser.setId(userId);
        newUser.setUser_name(users.getUser_name());
        newUser.setUser_password(users.getUser_password());

        usersMapper.update(newUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsers(@PathVariable(value = "id") int userId) {
        usersMapper.delete(userId);
    }
}

package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<User>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Kenneth", new Date(), "pass1", "961111-1111111"));
        users.add(new User(2, "Alice", new Date(), "pass2", "872222-2222222"));
        users.add(new User(3, "Elena", new Date(), "pass3", "763333-333333"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user : users){
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public User updateById(int id, User user) {
        for (User updateUser : users) {
            if (updateUser.getId() == id) {
                // 인덱스의 위치를 indexOf() 메서드를 활용한 이유는 삭제가 일어난 후 id를 인덱스로 하여 찾았을때 out of Bounds 가 발생하니 해당객체의 위치를 반환받아 수정
                users.get(users.indexOf(updateUser)).setName(user.getName());
                users.get(users.indexOf(updateUser)).setJoinDate(user.getJoinDate());
                return user;
            }
        }
        return null;
    }
}

package com.users.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.users.model.User;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		mongo.insert(u);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return mongo.findOne(new Query(Criteria.where("email").is(email)), User.class);
	}

}

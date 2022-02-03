package com.pumaray.lib.tools.adapter.json;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.pumaray.lib.model.user.PumUser;
import com.pumaray.lib.model.user.impl.PumDefaultUser;

public class PumUserJsonDeserializerTest {

	private Gson gson = new Gson();

	private PumUser generate(int number) {
		PumUser user = new PumDefaultUser();
		user.setName("Name " + number);
		user.setAlias("Alias " + number);
		return user;
	}

	private Collection<PumUser> generateMultiple(int amount) {
		Collection<PumUser> users = new ArrayList<PumUser>();
		for (int i = 0; i < amount; i++) {
			users.add(generate(i));
		}
		return users;
	}

	@Test
	public void testDesentrilize() {
		Collection<PumUser> users = generateMultiple(5);
		System.out.println(gson.toJson(users));
	}

}

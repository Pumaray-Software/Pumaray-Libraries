package com.pumaray.lib.model.tools.adapter.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.pumaray.lib.model.user.PumUser;
import com.pumaray.lib.model.user.impl.PumDefaultUser;

public class PumUserJsonDeserializer extends JsonDeserializer<PumUser> {

	@Override
	public PumUser deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		PumUser user = new PumDefaultUser();
		user.setName(node.get(PumUser.NAME).textValue());
		user.setAlias(node.get(PumUser.ALIAS).textValue());

		return user;
	}

}

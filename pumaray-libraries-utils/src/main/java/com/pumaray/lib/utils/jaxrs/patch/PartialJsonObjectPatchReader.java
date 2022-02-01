package com.pumaray.lib.utils.jaxrs.patch;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;

public class PartialJsonObjectPatchReader implements MessageBodyReader<ObjectPatch> {
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	public boolean isReadable(Class<?> patch, Type type, Annotation[] annotations, MediaType mediaType) {
		return ObjectPatch.class == type && MediaType.APPLICATION_JSON_TYPE.isCompatible(mediaType);
	}

	@Override
	public ObjectPatch readFrom(Class<ObjectPatch> type, Type genericType, Annotation[] annotation, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
		JsonNode patch = OBJECT_MAPPER.readTree(entityStream);
		return new PartialJsonObjectPatch(OBJECT_MAPPER, patch);
	}

}

package com.pumaray.lib.utils.xml.exporter;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import jakarta.xml.bind.SchemaOutputResolver;

public class PumSchemaExporter extends SchemaOutputResolver{
	
	private String namespaceUri;
	private String suggestedFileName;
	
	public PumSchemaExporter(String namespaceUri, String suggestedFileName) {
		this.setNamespaceUri(namespaceUri);
		this.setSuggestedFileName(suggestedFileName);
		
	}

	@Override
	public Result createOutput(String in1, String in2) throws IOException {
		File file = new File(suggestedFileName);
        StreamResult result = new StreamResult(file);
        result.setSystemId(file.toURI().toURL().toString());
        return result;
	}

	public String getNamespaceUri() {
		return namespaceUri;
	}

	public void setNamespaceUri(String namespaceUri) {
		this.namespaceUri = namespaceUri;
	}

	public String getSuggestedFileName() {
		return suggestedFileName;
	}

	public void setSuggestedFileName(String suggestedFileName) {
		this.suggestedFileName = suggestedFileName;
	}

}

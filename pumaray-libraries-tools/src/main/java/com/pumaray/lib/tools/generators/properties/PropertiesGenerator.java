package com.pumaray.lib.tools.generators.properties;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PropertiesGenerator {

	private static PropertiesGenerator generator = null;

	private Path parentPath;
	private Path destinationPath;

	public PropertiesGenerator(Path parentPath, Path destinationPath) {
		this.setParentPath(parentPath);
		this.setDestinationPath(destinationPath);
	}

	private static void init(Path parentPath, Path destinationPath) {
		if (generator == null) {
			generator = new PropertiesGenerator(parentPath, destinationPath);
		}
		else if (generator.getParentPath() != parentPath) {
			generator.setParentPath(parentPath);
		}
		else if (generator.getDestinationPath() != destinationPath) {
			generator.setDestinationPath(destinationPath);
		}
	}

	public static void generate(Path parentPath, Path destinationPath) throws IOException {
		init(parentPath, destinationPath);
		generator.generateImpl();
	}

	public void generateImpl() throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(
				destinationPath.toFile()), "UTF8");
		//FileWriter writer = new FileWriter(destinationPath.toFile());
		writer.write(getAllFileNames());
		writer.flush();
		writer.close();
	}

	public String getAllFileNames() throws IOException {
		StringBuilder builder = new StringBuilder();
		Files.walkFileTree(parentPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
					throws IOException {
				String root = parentPath.toUri().toString();
				String path = file.toUri().toString();
				String result = path.replace(root, "");
				builder.append(result + "\n");
				return FileVisitResult.CONTINUE;
			}
		});
		return builder.toString();
	}

	public Path getParentPath() {
		return parentPath;
	}

	public void setParentPath(Path parentPath) {
		this.parentPath = parentPath;
	}

	public Path getDestinationPath() {
		return destinationPath;
	}

	public void setDestinationPath(Path destinationPath) {
		this.destinationPath = destinationPath;
	}

}

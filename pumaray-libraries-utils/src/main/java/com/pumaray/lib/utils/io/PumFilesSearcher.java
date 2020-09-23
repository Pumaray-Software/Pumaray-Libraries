package com.pumaray.lib.utils.io;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PumFilesSearcher extends SimpleFileVisitor<Path> {

	private static Logger logger = LoggerFactory.getLogger(PumFilesSearcher.class);
	private static PumFilesSearcher searcher = null;
	private static final String PREFIX = "glob:";
	
	private String pattern;
	private List<Path> result = new ArrayList<Path>();
	private Path searchIn;
	private PathMatcher matcher;
	private FileSystem fileSystem;
	private boolean recursivly = true;

	public PumFilesSearcher(Path searchIn, String patternString, FileSystem fileSystem) {
		this.searchIn = searchIn;
		this.fileSystem = fileSystem;
		managePattern(patternString);
	}

	private static void init(Path searchIn, String patternString, FileSystem fileSystem) {
		if (searcher == null) {
			searcher = new PumFilesSearcher(searchIn, patternString, fileSystem);
		}
		else {
			if (searchIn != searcher.getSearchIn()) {
				searcher.setSearchIn(searchIn);
			}
			/*else if (!searcher.getPattern()
					.substring((searcher.getPattern().indexOf(PREFIX, searcher.getPattern().length())))
					.contains(patternString)) {
				searcher.managePattern(patternString);
			}*/
			else if(!searcher.getPattern().equals(generatePattern(patternString))) {
				searcher.managePattern(patternString);
			}
			else if (fileSystem != searcher.getFileSystem()) {
				searcher.setFileSystem(fileSystem);
			}
		}
	}

	private static String extensionToPattern(String... extensions) {
		StringBuilder builder = new StringBuilder();
		builder.append("**.{");
		for (String str : extensions) {
			builder.append(str);
			builder.append(",");
		}
		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		builder.append("}");
		return builder.toString();
	}

	private void find(Path path) {
		if (path != null && matcher.matches(path)) {
			result.add(path);
		}
	}
	
	private static String generatePattern(String patternString) {
		return "glob:" + patternString;
	}

	private void managePattern(String patternString) {
		setPattern(generatePattern(patternString));
		matcher = FileSystems.getDefault().getPathMatcher(getPattern());
	}

	public static List<Path> searchForFilesConformPattern(Path dir, String patternString, FileSystem fileSystem)
			throws IOException {
		init(dir, patternString, fileSystem);
		searcher.search();
		return searcher.getResult();
	}

	public static List<Path> searchForFilesWithExtensions(Path dir, FileSystem fileSystem,String... extensions)
			throws IOException {
		return searchForFilesConformPattern(dir, extensionToPattern(extensions), fileSystem);
	}
	
	public static List<Path> searchForFilesWithExtensions(Path dir, FileSystem fileSystem,List<String> extensionsList)
			throws IOException {
		String [] extensions = extensionsList.toArray(new String[0]);
		return searchForFilesConformPattern(dir, extensionToPattern(extensions), fileSystem);
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		find(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		find(dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		System.err.println(exc);
		return FileVisitResult.CONTINUE;
	}
	
	public void search() throws IOException  {
		getResult().clear();
		Files.walkFileTree(getSearchIn(), this);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public List<Path> getResult() {
		return result;
	}

	public void setResult(List<Path> result) {
		this.result = result;
	}

	public Path getSearchIn() {
		return searchIn;
	}

	public void setSearchIn(Path searchIn) {
		this.searchIn = searchIn;
	}

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}

	public boolean isRecursivly() {
		return recursivly;
	}

	public void setRecursivly(boolean recursivly) {
		this.recursivly = recursivly;
	}
}

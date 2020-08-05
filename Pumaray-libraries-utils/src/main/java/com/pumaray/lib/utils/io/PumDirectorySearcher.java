package com.pumaray.lib.utils.io;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PumDirectorySearcher extends SimpleFileVisitor<Path> {

	private final static Logger logger = LoggerFactory.getLogger(PumDirectorySearcher.class);

	private static PumDirectorySearcher searcher = null;

	public List<Path> directories = new ArrayList<Path>();
	private Path rootPath;
	private int depth = -1;

	public PumDirectorySearcher(Path rootPath) {
		this.setRootPath(rootPath);
	}

	private static void init(Path path) {
		if (searcher == null) {
			searcher = new PumDirectorySearcher(path);
		}
		else {
			if (searcher.getRootPath() != path) {
				searcher.setRootPath(path);
			}
		}
	}
	
	public static List<Path> retrieveAllSubDirectories(Path path) throws IOException {
		init(path);
		searcher.setDepth(-1);
		searcher.search();
		return searcher.getDirectories();
	}

	public static List<Path> retrieveAllSubDirectories(Path path, int depth)
			throws IOException {
		init(path);
		searcher.setDepth(depth);
		searcher.search();
		return searcher.getDirectories();
	}

	public void search() throws IOException {
		directories.clear();
		if(depth == -1) {
			Files.walkFileTree(rootPath, this);
		}
		else {
			Files.walkFileTree(rootPath, EnumSet.noneOf(FileVisitOption.class), getDepth(), this);
		}
	}

	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		if(dir != rootPath) {
			directories.add(dir);
		}
		return FileVisitResult.CONTINUE;
	}

	public Path getRootPath() {
		return rootPath;
	}

	public void setRootPath(Path rootPath) {
		this.rootPath = rootPath;
	}

	public List<Path> getDirectories() {
		return directories;
	}

	public void setDirectories(List<Path> directories) {
		this.directories = directories;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}

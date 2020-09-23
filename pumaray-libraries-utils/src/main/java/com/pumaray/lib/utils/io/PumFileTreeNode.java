package com.pumaray.lib.utils.io;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PumFileTreeNode extends HashMap<Integer, List<Path>> {
	
	public PumFileTreeNode() {}
	
	public void addPath(int position, Path path) {
		if(containsKey(position) ) {
			get(position).add(path);
		}
		else {
			List<Path> list = new ArrayList<Path>();
			list.add(path);
			put(position, list);
		}
	}
	
	public Path getPath(int pos,Path end) {
		if(!containsKey(pos)) {
			throw new NullPointerException();
		}
		else {
			String endString = end.toString() ;
			List<Path> list = get(pos);
			return search(list, endString+"/");
		}
	}
	
	private Path search(List<Path> paths, String endsWith) {
		for(Path path : paths) {
			if(path.toString().endsWith(endsWith.toString())){
				return path;
			}
		}
		throw new NullPointerException();
	}

}

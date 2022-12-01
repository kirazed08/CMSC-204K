package application;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root = null;
	private String letter;
	
public MorseCodeTree() {
	buildTree();
}
	@Override
	public TreeNode<String> getRoot() {
		
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		
		addNode(root, code, letter);
		 return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
			TreeNode<String>leftChildroot = root.LeftChild;
	
	    if(code.length() == 1) {
	    	if(code.equals(".")) {
	    		root.LeftChild = new TreeNode<String>(letter);
	    	}else if(code.equals("-")) {
	    		root.RightChild = new TreeNode<String>(letter);
	    	}else if(code.equals(".-")) {
	    		leftChildroot.RightChild = new TreeNode<String>(letter);
	    	}
	    	
	    	return;
	    }
	    else { 
	    	if(code.length() > 1) {
	    
	    	if(code.charAt(0) == ('.')) {
	    		addNode(root.LeftChild,code.substring(1),letter);
	    	}else if(code.charAt(0) == '-') {
	    		addNode(root.RightChild,code.substring(1),letter);
	    	}else if(code == ".-") {
	    		leftChildroot.RightChild = new TreeNode<String>(letter);
	    	}
	    	}
	    	
	    }
	    	
	    }
	@Override
	public String fetch(String code) {
		String letter = "";
		 letter = fetchNode(root,code);
		return letter;
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
			if(code.length() == 1) {
				if(code.equals(".") ) {
					letter = root.LeftChild.getData();
				}else if( code.equals("-")) {
					letter =  root.RightChild.getData();
				}
			}else {
				if(code.length() > 1) {
			}
		if(code.substring(0,1).equals( ".") ) {
			 fetchNode(root.LeftChild,code.substring(1));
		}else if(code.substring(0,1).equals("-")) {
			 fetchNode(root.RightChild,code.substring(1));
		}
			}
			
				
		return letter;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
				return null;
	}

	@Override
	public void buildTree() {
		root = new TreeNode<String>("");
		  insert(".", "e");
	       insert("-", "t");
	     
	       insert("..", "i");
	       insert(".-", "a");
	       insert("-.", "n");
	       insert("--", "m");
	      
	       insert("...", "s");
	       insert("..-", "u");
	       insert(".-.", "r");
	       insert(".--", "w");
	       insert("-..", "d");
	       insert("-.-", "k");
	       insert("--.", "g");
	       insert("---", "o");
	       
	       insert("....", "h");
	       insert("...-", "v");
	       insert("..-.", "f");
	       insert(".-..", "l");
	       insert(".--.", "p");
	       insert(".---", "j");
	       insert("-...", "b");
	       insert("-..-", "x");
	       insert("-.-.", "c");
	       insert("-.--", "y");
	       insert("--..", "z");
	       insert("--.-", "q");                  
		
	}

	@Override
	public ArrayList<String> toArrayList() {
	
	ArrayList<String> list = new ArrayList<String>();
	LNRoutputTraversal(root, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
				if( root == null) {
					return;
				}
				 LNRoutputTraversal(root.LeftChild, list);
				 			list.add(root.getData());
				 LNRoutputTraversal(root.RightChild, list);
				 
	}

}
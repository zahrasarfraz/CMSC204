package assignment2222;

import java.util.ArrayList;

//okay so do the recursive method of the add gain 
/**
 * The morseCodeTree class that implements the LinkedConverterTreeInterface
 * @author ZahraSarfraz
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String>root;
	
	/**
	 * Calls the buildTree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<>("");
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode the new node 
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root=newNode;
	}

	/**
	 * Adds element to the correct position in the tree 
	 * based on the code This method will call the recursive method addNode
	 * @param code the code of the morse code
	 * @param result the result of the code
	 */
	@Override
	//	public void insert(String code, String letter) {
	// addNode(root, code, result);
	public void insert(String code, String result) {
		addNode(root, code, result);
	}

	/**
	 * A recursive methodd that adds element based on their morsecode
	 * @param root the node's root
	 * @param code the code of the letter
	 * @param letter letter to add
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter){
		//if there is only one character a. if the character is '.' (dot) store to the left of the current root
		//b. if the character is "-" (dash) store to the right of the current root
		//c. return
		
		//okay so we cant use array find out what else we can use to traverse the remianig of the code

		TreeNode<String> Tree = new TreeNode<>(letter); 
		char firstChar = code.charAt(0); 

		//if there is only one character a. if the character is '.' (dot) store to the left of the current root
		//b. if the character is "-" (dash) store to the right of the current root
		//c. return
		if (code.length() == 1) 
		{
		    if (firstChar == '.') {
		            root.left = Tree; 
		    } else if (firstChar == '-') {
		            root.right = Tree;
		    }else  {
		    	return;
		    }
		}
		//if there is more than one character a. if the first character is "." (dot) new root becomes the left child 
		//b. if the first character is "-" (dash) new root becomes the right child 
		//c. new code becomes all the remaining charcters in the code (beyond the first character)
		//d. call addNode(new root, new code, letter)

		else if(code.length()>1)
		{
		    TreeNode<String> newRoot = root; 

		    if (firstChar == '.') {
		        newRoot = root.left;
		    } else if (firstChar == '-') {
		        newRoot = root.right;
		    }
		    
			String newCode = code.substring(1); 
		  //d. call addNode(new root, new code, letter)
		    addNode(newRoot, newCode, letter); 
		}
	}
	
	/**
	 * gets a letter from the tree
	 * @param code the code of the letter
	 * @return the string (letter) that corresponds to the code 
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root,code);
	}
	
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * @param root root of the tree
	 * @param code code if the letter
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {		
		//This is the recursive method that fetches the data of the TreeNode that corresponds
		//with the code A '.' (dot) means traverse to the left. A "-" (dash) means
		//traverse to the right. The code ".-" would fetch the data of the TreeNode 
		//stored as the right child of the left child of the root
		String letter = "";
		char firstChar = code.charAt(0);

		if (code.length() == 1)
		{
		    if (firstChar == '.') 
		    {
		        letter = root.left.getData();
		    } else {
		        letter = root.right.getData();
		    }
		} //if bracket
		else if(code.length()>1) //now if more than one then check if . then root.left otherwise root.left
		{
		    TreeNode<String> newRoot = root;

		    if (firstChar == '.')
		    {
		        newRoot = root.left;
		    } else{
		        newRoot = root.right;
		    }

		   //okay now for the rest of the code do this same use for or if lopp
		    String newLetter = "";
		    for (int i = 1; i < code.length(); i++) {
		        newLetter += code.charAt(i);
		    }

		    letter = fetchNode(newRoot, newLetter);
		}//else if
		return letter;
	}

	/**
	 * deletes the data
	 * @param data data to be deleted
	 * @throws java.lang.UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * updates the data
	 * @param data the data to be updatesd
	 * @throws java.lang.UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Builds the tree for the morse code 
	 */
	@Override
	public void buildTree() {
		// add the names the . or - for each the word by insert thats it 
		insert(".","e");
		insert("-","t");
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		insert("....","h");//check if this is still right !!!!!!
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	/**
	 * converts the tree into an arraylist
	 * @return list the arraylist of the letters
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal 
		//order Used for testing to make sure tree is built correctly
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}

	/**
	 * adds the items accordingly to the arraylist
	 * @param root the node current root
	 * @param list the arraylist where to add the items
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		//first do recursive left add the .getData and then do the recursive right 
		if(root!=null)
		{
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}

	}
}

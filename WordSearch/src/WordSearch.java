    import java.util.*;
     
    class WordSearch{
     
    	public static Scanner console = new Scanner(System.in);
     
    	public static int findAll(char[][] grid, String word){
    		int count = 0;
    		count += findHorizontalAll(grid, word);
    		count += findVerticalAll(grid, word);
    		count += findDiagonalAll(grid, word);
    		return count;
    	}
     
    	public static int findHorizontalAll(char[][] grid, String word){
    		int count = 0;
    		count += findHorizontal(grid, word);
    		count += findHorizontal(flipH(grid), word);
    		return count;
    	}
     
    	public static int findVerticalAll(char[][] grid, String word){
    		int count = 0;
    		count += findVertical(grid, word);
    		count += findVertical(flipV(grid),word);
    		return count;
    	}
     
    	public static int findDiagonalAll(char[][] grid, String word){
    		int count = 0;
     
    		count += findDiagonal(grid,word);				//UL to LR
    		count += findDiagonal(flipV(grid),word);		//LL to UR
    		count += findDiagonal(flipH(grid),word);		//UR to LL
    		count += findDiagonal(flipV(flipH(grid)),word);	//LR to UL
    		return count;
    	}
     
    	public static int findHorizontal(char[][] grid, String word){
     
    		int y = grid.length;
    		int x = grid[0].length;
    		int w = word.length();
    		int count = 0;
    		int match = 0;
    		char[] search = word.toCharArray();
     
    		for(int i =0; i < y; i++){
    			for(int j =0; j < (x-w+1); j++){
    				count = 0;
    				for(int k = 0; k < w ; k++){
    															//System.out.println("search: " + search[k] + " grid[" +i+"]["+j+k+"]: " + grid[i][j+k]);
    					if(search[k] == grid[i][j+k]){			//if letter in selection[n] matches letter in word[n]
    						count++;
    					}
     
    					if(count>= w){							//if subset matches all letters of word
    						match++;
    						count = 0;
    					}
    				}											//loop char in word
    			}												//loop col
    		}													//loop row
    		return match;
    	}
     
    	public static int findVertical(char[][] grid, String word){
    		int y = grid.length;
    		int x = grid[0].length;
    		int w = word.length();
    		int count = 0;
    		int match = 0;
    		char[] search = word.toCharArray();
     
    		for(int i =0; i < (y-w+1); i++){
    			for(int j =0; j < x; j++){
    				count = 0;
    				for(int k = 0; k < w ; k++){
    															//System.out.println("search: " + search[k] + " grid[" +i+k+"]["+j+"]: " + grid[i+k][j]);
    					if(search[k] == grid[i+k][j]){			//if letter in selection[n] matches letter in word[n]
    						count++;
    					}
     
    					if(count>= w){							//if subset matches all letters of word
    						match++;
    						count = 0;
    					}
    				}											//loop char in word
    			}												//loop col
    		}													//loop row
    		return match;
    	}
     
    	public static int findDiagonal(char[][] grid, String word){
    			int y = grid.length;
    			int x = grid[0].length;
    			int w = word.length();
    			int count = 0;
    			int match = 0;
    			char[] search = word.toCharArray();
     
    			for(int i =0; i < (y-w+1); i++){
    				for(int j =0; j < (x-w+1); j++){
    					count = 0;
    					for(int k = 0; k < w ; k++){
    																//System.out.println("search: " + search[k] + " grid[" +i+k+"]["+j+k+"]: " + grid[i+k][j+k]);
    						if(search[k] == grid[i+k][j+k]){		//if letter in selection[n] matches letter in word[n]
    							count++;
    						}
     
    						if(count>= w){							//if subset matches all letters of word
    							match++;
    							count = 0;
    						}
    					}											//loop char in word
    				}												//loop col
    			}													//loop row
    			return match;
    	}
     
    	public static char[][] flipH(char[][] grid){
    		int y = grid.length;
    		int x = grid[0].length;
    		char[][] temp = new char[y][x];
     
    		for(int i = 0; i < y; i++){
    			for(int j = 0; j < x; j++){
    				temp[i][j] = grid[i][x-j-1];
    			}
    		}
    		return temp;
    	}
     
    	public static char[][] flipV(char[][] grid){
    		int y = grid.length;
    		int x = grid[0].length;
    		char[][] temp = new char[y][x];
     
    		for(int i = 0; i < y; i++){
    			for(int j = 0; j < x; j++){
    				temp[i][j] = grid[y-i-1][j];
    			}
    		}
    		return temp;
    	}
     
    	public static void main (String[] args) throws java.lang.Exception{
     
    		int cases = console.nextInt();
     
    		int n;
    		int m;
     
    		String word;
    		String temp;
     
    		//char[][] grid = new char[5][5];
     
    		for(int c = 0; c < cases; c++){
    			n = console.nextInt();
    			m = console.nextInt();
    			char[][] grid = new char[n][m];
    			char[] tempChar = new char[m];
     
    			for(int i=0; i < n; i++){
    				temp=console.next();
    				tempChar = temp.toCharArray();
    				for(int j=0; j < m; j++){
    					grid[i][j] = tempChar[j];
    				}
    			}
     
    			word = console.next();
    			System.out.println("Case " + (c+1) + ": "  +findAll(grid,word));
     
    		}//case loop
     
    	}//main
    }//class